package com.t1gerok.calculator.Service;

import com.t1gerok.calculator.exception.ServerException;
import com.t1gerok.calculator.model.Expression1;
import com.t1gerok.calculator.model.Type;
import com.t1gerok.calculator.service.Parser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestParser {
    Parser parser = new Parser();

    @Test
    public void testGetExpressionAdd() throws ServerException {
        Expression1 expression1 = parser.getExpressionFromString("2434+234343", Type.ADDITION);
        Assertions.assertEquals(expression1.getA(), 2434);
    }

    @Test
    public void testGetExpressionSub() throws ServerException {
        Expression1 expression1 = parser.getExpressionFromString("234343-11111", Type.SUBTRACTION);
        Assertions.assertEquals(expression1.getA(), 234343);
    }

    @Test
    public void testExpressionParser() throws ServerException {
        List<String> stringList = parser.expressionParser("(33+22)*44*(22-33*(33+44-55))");
        stringList.size();
    }

    @Test
    public void testExpressionSplitter(){
        List<String> expressions = new ArrayList<>();
        expressions.add("3-4*5/6");
        List<List<String>> res = parser.expressionSplitter(expressions);
        res.size();
    }
}
