package com.t1gerok.calculator.dao;

import com.t1gerok.calculator.exception.ServerException;
import com.t1gerok.calculator.model.Session;
import com.t1gerok.calculator.model.User;

public interface UserDao {
    User insert(User user) throws ServerException;

    Session login(String login, String password, Session session) throws ServerException;

    boolean logout(String sessionId) throws ServerException;

    User getBySessionId(String sessionId) throws ServerException;
}
