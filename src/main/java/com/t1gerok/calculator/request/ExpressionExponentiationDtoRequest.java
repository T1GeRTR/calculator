package com.t1gerok.calculator.request;

import java.util.Objects;

public class ExpressionExponentiationDtoRequest {
    private int x;
    private int y;

    public ExpressionExponentiationDtoRequest(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExpressionExponentiationDtoRequest)) return false;
        ExpressionExponentiationDtoRequest that = (ExpressionExponentiationDtoRequest) o;
        return getX() == that.getX() &&
                getY() == that.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }
}
