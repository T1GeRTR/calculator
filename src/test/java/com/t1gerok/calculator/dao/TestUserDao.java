package com.t1gerok.calculator.dao;

import com.t1gerok.calculator.exception.ServerException;
import com.t1gerok.calculator.model.Session;
import com.t1gerok.calculator.model.User;
import com.t1gerok.calculator.mybatis.daoimpl.UserDaoImpl;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestUserDao {
    UserDao userDao = new UserDaoImpl();

    @Test
    public void testInsert() throws ServerException {
        User user = new User("admin", "password");
        userDao.insert(user);
        Assertions.assertNotEquals(0, user.getId());
    }

    @Test
    public void testInsertFail() {
        assertThrows(ServerException.class, () -> {
            User user = new User("admin2", "password");
            userDao.insert(user);
            User user2 = new User("admin2", "password");
            userDao.insert(user2);
        });
    }

    @Test
    public void testLogin() throws ServerException {
        userDao.insert(new User("admin3", "password"));
        Assertions.assertNotNull(userDao.login("admin3", "password", new Session("123456Admin")));
    }

    @Test
    public void testLoginFail() {
        assertThrows(ServerException.class, () -> userDao.login("wrongLogin", "passWrong", new Session("123456455523523Wrong")));
    }

    @Test
    public void testGetBySession() throws ServerException {
        userDao.insert(new User("admin4", "password"));
        userDao.login("admin4", "password", new Session("1234567Admin"));
        User user = userDao.getBySessionId("1234567Admin");
        Assertions.assertNotEquals(0, user.getId());
    }

    @Test
    public void testGetBySessionFail() {
        assertThrows(ServerException.class, () -> userDao.getBySessionId("wrongSessionId"));
    }


    @Test
    public void testLogout() throws ServerException {
        userDao.insert(new User("admin5", "password"));
        userDao.login("admin5", "password", new Session("12345678Admin"));
        userDao.logout("12345678Admin");
        assertThrows(ServerException.class, () -> userDao.logout("12345678Admin"));
    }

    @Test
    public void testLogoutFail() {
        assertThrows(ServerException.class, () -> userDao.logout("wrongSessionId"));
    }
}
