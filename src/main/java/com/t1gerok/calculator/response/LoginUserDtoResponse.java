package com.t1gerok.calculator.response;

import com.t1gerok.calculator.model.User;

import java.util.Objects;
import java.util.UUID;

public class LoginUserDtoResponse {
    private String sessionId;
    private User user;

    public LoginUserDtoResponse() {
        this.sessionId = UUID.randomUUID().toString();
        this.user = null;
    }

    public LoginUserDtoResponse(String sessionId, User user) {
        this.sessionId = sessionId;
        this.user = user;
    }

    public LoginUserDtoResponse(String sessionId) {
        this(sessionId, null);
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
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
        if (!(o instanceof LoginUserDtoResponse)) return false;
        LoginUserDtoResponse that = (LoginUserDtoResponse) o;
        return Objects.equals(getSessionId(), that.getSessionId()) &&
                Objects.equals(getUser(), that.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSessionId(), getUser());
    }
}
