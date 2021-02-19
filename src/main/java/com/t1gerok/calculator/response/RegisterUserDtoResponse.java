package com.t1gerok.calculator.response;

import java.util.Objects;

public class RegisterUserDtoResponse {
    private int id;
    private String login;
    private String password;

    public RegisterUserDtoResponse(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public RegisterUserDtoResponse(String login, String password) {
        this(0, login, password);
    }

    public RegisterUserDtoResponse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegisterUserDtoResponse)) return false;
        RegisterUserDtoResponse user = (RegisterUserDtoResponse) o;
        return getId() == user.getId() &&
                getLogin().equals(user.getLogin()) &&
                getPassword().equals(user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLogin(), getPassword());
    }
}
