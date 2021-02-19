package com.t1gerok.calculator.request;

import java.util.Objects;

public class RegisterUserDtoRequest {
    private String login;
    private String password;

    public RegisterUserDtoRequest(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public RegisterUserDtoRequest() {
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
        if (o == null || getClass() != o.getClass()) return false;
        RegisterUserDtoRequest that = (RegisterUserDtoRequest) o;
        return Objects.equals(login, that.login) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }
}
