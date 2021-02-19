package com.t1gerok.calculator.controller;

import com.t1gerok.calculator.exception.ServerException;
import com.t1gerok.calculator.request.LoginUserDtoRequest;
import com.t1gerok.calculator.request.RegisterUserDtoRequest;
import com.t1gerok.calculator.response.EmptyResponse;
import com.t1gerok.calculator.response.LoginUserDtoResponse;
import com.t1gerok.calculator.response.RegisterUserDtoResponse;
import com.t1gerok.calculator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public RegisterUserDtoResponse register(@RequestBody RegisterUserDtoRequest request) throws ServerException {
        return userService.register(request);
    }

    @PostMapping(path = "/user/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public LoginUserDtoResponse login(@RequestBody LoginUserDtoRequest request) throws ServerException {
        return userService.login(request.getLogin(), request.getPassword());
    }

    @PostMapping(path = "/user/logout", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public EmptyResponse logout(@CookieValue("JAVASESSIONID") String sessionId) throws ServerException {
        return userService.logout(sessionId);
    }
}
