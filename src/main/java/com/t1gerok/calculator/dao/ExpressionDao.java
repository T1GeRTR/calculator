package com.t1gerok.calculator.dao;

import com.t1gerok.calculator.exception.CalculatorException;
import com.t1gerok.calculator.model.Expression;
import com.t1gerok.calculator.model.Type;

import java.time.LocalDateTime;
import java.util.List;

public interface ExpressionDao {
    Expression insert(Expression expression) throws CalculatorException;

    List<Expression> getByType(Type type) throws CalculatorException;

    List<Expression> getByDateTime(LocalDateTime from, LocalDateTime to) throws CalculatorException;

    List<Exception> getByUserId(int userId) throws CalculatorException;
}
