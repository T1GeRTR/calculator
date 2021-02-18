package com.t1gerok.calculator.model;

import java.util.Objects;

public class Expression1 {
    private Type type;
    private int a;
    private int b;

    public Expression1(Type type, int a, int b) {
        this.type = type;
        this.a = a;
        this.b = b;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expression1 that = (Expression1) o;
        return a == that.a && b == that.b && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, a, b);
    }
}
