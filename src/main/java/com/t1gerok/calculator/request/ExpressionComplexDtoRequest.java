package com.t1gerok.calculator.request;

import java.util.Objects;

public class ExpressionComplexDtoRequest {
    private String expression;

    public ExpressionComplexDtoRequest(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpressionComplexDtoRequest that = (ExpressionComplexDtoRequest) o;
        return Objects.equals(expression, that.expression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expression);
    }
}
