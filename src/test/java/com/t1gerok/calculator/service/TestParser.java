package com.t1gerok.calculator.service;

import com.t1gerok.calculator.exception.ServerException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestParser {
    Parser parser = new Parser();

    @Test
    public void testExpressionParser() throws ServerException {
        List<String> stringList = parser.expressionParser("(33+22)*44*(22-33*(33+44-55))");
        stringList.size();
    }

    @Test
    public void testExpressionSplitter(){
        List<String> expressions = new ArrayList<>();
        expressions.add("3-4*5/6");
        expressions.add("#0+44*55/66");
        expressions.add("31-#1/54*6");
        List<List<String>> res = parser.expressionSplitter(expressions);
        res.size();
    }

    @Test
    public void testGetResultFromString() throws ServerException {
        Assertions.assertEquals("4", parser.getResultFromString("2+2"));
        Assertions.assertEquals("4", parser.getResultFromString("2*2"));
        Assertions.assertEquals("1", parser.getResultFromString("2/2"));
        Assertions.assertEquals("100", parser.getResultFromString("10*10"));
        Assertions.assertEquals("0", parser.getResultFromString("2-2"));
    }

    @Test
    public void testCalculate() throws ServerException{
        String res = parser.calculate("(3+2)*4*(2-3*(3+4-5))");
        System.out.println(res);
    }
}
