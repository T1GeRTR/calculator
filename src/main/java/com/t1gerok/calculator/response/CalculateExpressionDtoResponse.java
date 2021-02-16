package com.t1gerok.calculator.response;

import com.t1gerok.calculator.model.Expression;
import com.t1gerok.calculator.model.Status;
import com.t1gerok.calculator.model.Type;
import com.t1gerok.calculator.model.User;

import java.time.LocalDateTime;
import java.util.Objects;

public class CalculateExpressionDtoResponse {
    private int id;
    private Type type;
    private String string;
    private float result;
    private Status status;
    private LocalDateTime datetime;
    private User user;

    public CalculateExpressionDtoResponse(int id, Type type, String string, float result, Status status, LocalDateTime datetime, User user) {
        this.id = id;
        this.type = type;
        this.string = string;
        this.result = result;
        this.status = status;
        this.datetime = datetime;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public float getResult() {
        return result;
    }

    public void setResult(float result) {
        this.result = result;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Expression)) return false;
        Expression that = (Expression) o;
        return getId() == that.getId() &&
                Float.compare(that.getResult(), getResult()) == 0 &&
                getType() == that.getType() &&
                Objects.equals(getString(), that.getString()) &&
                getStatus() == that.getStatus() &&
                Objects.equals(getDatetime(), that.getDatetime()) &&
                Objects.equals(getUser(), that.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getType(), getString(), getResult(), getStatus(), getDatetime(), getUser());
    }
}
