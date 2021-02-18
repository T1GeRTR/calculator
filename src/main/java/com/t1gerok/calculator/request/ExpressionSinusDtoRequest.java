package com.t1gerok.calculator.request;

import java.util.Objects;

public class ExpressionSinusDtoRequest {
    private int x;

    public ExpressionSinusDtoRequest(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpressionSinusDtoRequest that = (ExpressionSinusDtoRequest) o;
        return x == that.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x);
    }
}
