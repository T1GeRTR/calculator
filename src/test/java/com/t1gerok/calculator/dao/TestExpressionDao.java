package com.t1gerok.calculator.dao;

import com.t1gerok.calculator.exception.ServerException;
import com.t1gerok.calculator.model.Expression;
import com.t1gerok.calculator.model.Status;
import com.t1gerok.calculator.model.Type;
import com.t1gerok.calculator.model.User;
import com.t1gerok.calculator.mybatis.daoimpl.ExpressionDaoImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class TestExpressionDao {
    ExpressionDao expressionDao = new ExpressionDaoImpl();

    @Test
    public void testInsertAdd() throws ServerException {
        Expression expression = new Expression(Type.ADDITION, "2+2", 4f, Status.OK, LocalDateTime.now(), new User(1, "", ""));
        expressionDao.insert(expression);
        Assertions.assertNotEquals(0, expression.getId());
    }

    @Test
    public void testInsertDiv() throws ServerException {
        Expression expression = new Expression(Type.DIVISION, "2/0", 0, Status.ERROR, LocalDateTime.now(), new User(1, "", ""));
        expressionDao.insert(expression);
        Assertions.assertNotEquals(0, expression.getId());
    }


}
