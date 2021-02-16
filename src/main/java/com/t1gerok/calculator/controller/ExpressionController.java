package com.t1gerok.calculator.controller;

import com.t1gerok.calculator.exception.ServerException;
import com.t1gerok.calculator.model.Type;
import com.t1gerok.calculator.request.ExpressionAdditionDtoRequest;
import com.t1gerok.calculator.response.CalculateExpressionDtoResponse;
import com.t1gerok.calculator.service.ExpressionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpressionController {
    @Autowired
    private ExpressionService expressionService;

    @PostMapping(path = "/calculate/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CalculateExpressionDtoResponse calcAddition(@CookieValue("JAVASESSIONID") String sessionId, @RequestBody ExpressionAdditionDtoRequest request) throws ServerException {
        return expressionService.calculate(request.getX() + "+" + request.getY(), Type.ADDITION, sessionId);
    }
}
