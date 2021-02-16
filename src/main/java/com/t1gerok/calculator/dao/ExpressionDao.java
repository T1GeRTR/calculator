package com.t1gerok.calculator.dao;

import com.t1gerok.calculator.exception.ServerException;
import com.t1gerok.calculator.model.Expression;
import com.t1gerok.calculator.model.Type;

import java.time.LocalDateTime;
import java.util.List;

public interface ExpressionDao {
    Expression insert(Expression expression) throws ServerException;

    List<Expression> getByType(Type type) throws ServerException;

    List<Expression> getByDateTime(LocalDateTime from, LocalDateTime to) throws ServerException;

    List<Expression> getByUserId(int userId) throws ServerException;
}
