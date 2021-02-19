package com.t1gerok.calculator.service;

import com.t1gerok.calculator.dao.UserDao;
import com.t1gerok.calculator.exception.ErrorCode;
import com.t1gerok.calculator.exception.ServerException;
import com.t1gerok.calculator.model.Session;
import com.t1gerok.calculator.model.User;
import com.t1gerok.calculator.request.RegisterUserDtoRequest;
import com.t1gerok.calculator.response.EmptyResponse;
import com.t1gerok.calculator.response.LoginUserDtoResponse;
import com.t1gerok.calculator.response.RegisterUserDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public RegisterUserDtoResponse register(RegisterUserDtoRequest request) throws ServerException {
        User user = new User(request.getLogin(), request.getPassword());
        user = userDao.insert(user);
        return new RegisterUserDtoResponse(user.getId(), user.getLogin(), user.getPassword());
    }

    public LoginUserDtoResponse login(String login, String password) throws ServerException {
        Session session = userDao.login(login, password, new Session());
        return new LoginUserDtoResponse(session.getSessionId(), session.getUser());
    }

    public EmptyResponse logout(String sessionId) throws ServerException {
        if (userDao.logout(sessionId)) {
            return new EmptyResponse();
        }
        throw new ServerException(ErrorCode.CANT_LOGOUT);
    }
}
