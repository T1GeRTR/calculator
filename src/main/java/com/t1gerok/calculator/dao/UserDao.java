package com.t1gerok.calculator.dao;

import com.t1gerok.calculator.exception.CalculatorException;
import com.t1gerok.calculator.model.Session;
import com.t1gerok.calculator.model.User;

public interface UserDao {
    User insert(User user) throws CalculatorException;

    Session login(String login, String password, Session session) throws CalculatorException;

    boolean logout(String sessionId) throws CalculatorException;

    User getBySessionId(String sessionId) throws CalculatorException;
}
