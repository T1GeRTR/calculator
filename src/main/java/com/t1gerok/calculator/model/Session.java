package com.t1gerok.calculator.model;

import java.util.Objects;
import java.util.UUID;

public class Session {
    private String sessionId;
    private User user;

    public Session() {
        this.sessionId = UUID.randomUUID().toString();
        this.user = null;
    }

    public Session(String sessionId, User user) {
        this.sessionId = sessionId;
        this.user = user;
    }

    public Session(String sessionId) {
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
        if (!(o instanceof Session)) return false;
        Session that = (Session) o;
        return Objects.equals(getSessionId(), that.getSessionId()) &&
                Objects.equals(getUser(), that.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSessionId(), getUser());
    }
}
