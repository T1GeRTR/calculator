package com.t1gerok.calculator.service;

import com.t1gerok.calculator.exception.ErrorCode;
import com.t1gerok.calculator.exception.ServerException;
import com.t1gerok.calculator.model.Expression1;
import com.t1gerok.calculator.model.Type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {

    public List<String> expressionParser(String expression) {
        List<String> expressions = new ArrayList<>();
        StringBuilder str = new StringBuilder(expression);
        while (str.indexOf("(") != -1) {
            char[] array = str.toString().toCharArray();
            int start = 0;
            int end = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == '(') {
                    start = i;
                }
                if (array[i] == ')') {
                    end = i;
                    break;
                }
            }
            String part = str.substring(start + 1, end);
            expressions.add(part);
            str.replace(start, end + 1, "#" + expressions.indexOf(part));
        }
        expressions.add(str.toString());
        return expressions;
    }

    public List<List<String>> expressionSplitter(List<String> expressions) {
        List<List<String>> listSimpleExpressions = new ArrayList<>();
        for (String elem: expressions){
            StringBuilder str = new StringBuilder(elem);
            List<String> simpleExpressions = new ArrayList<>();
            while (str.toString().replaceAll("[^+\\*\\-\\/]", "").length()!=0) {
                char[] array = str.toString().toCharArray();
                for (int i = 0; i < array.length; i++) {
                    char splitter = '/';
                    if (str.indexOf(String.valueOf(splitter))==-1){
                        splitter = '*';
                        if (str.indexOf(String.valueOf(splitter))==-1){
                            splitter = '+';
                            if (str.indexOf(String.valueOf(splitter))==-1){
                                splitter = '-';
                            }
                        }
                    }
                    if (array[i] == splitter) {
                        String simpleExpression = splitter(str, splitter, i);
                        simpleExpressions.add(simpleExpression);
                        str.replace(str.indexOf(simpleExpression), str.indexOf(simpleExpression) + simpleExpression.length(), "$" + simpleExpressions.indexOf(simpleExpression));
                        break;
                    }
                }
            }
            listSimpleExpressions.add(simpleExpressions);
        }
        return listSimpleExpressions;
    }



    private String splitter(StringBuilder str, char splitter, int i){
        String before = str.substring(0,i);
        String after = str.substring(i+1);
        String[] splitBefore = (before.replaceAll("[^$\\#\\d]", " ").trim()).split(" ");
        String[] splitAfter = (after.replaceAll("[^$\\#\\d]", " ").trim()).split(" ");
        return  splitBefore[splitBefore.length-1]+ splitter + splitAfter[0];
    }

    public float getResultFromString(String str) throws ServerException {
        String splitter = str.replaceAll("[^+\\*\\-\\/]", "");
        final int a = Integer.parseInt(str.substring(0, str.indexOf(splitter)));
        final int b = Integer.parseInt(str.substring(str.indexOf(splitter) + 1));
        switch (splitter) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "/":
                return a / b;
            case "*":
                return a * b;
            default:
                throw new ServerException(ErrorCode.DATABASE_ERROR);
        }
    }
}
