package com.t1gerok.calculator.controller;

import com.t1gerok.calculator.exception.ServerException;
import com.t1gerok.calculator.model.Type;
import com.t1gerok.calculator.request.*;
import com.t1gerok.calculator.response.CalculateExpressionDtoResponse;
import com.t1gerok.calculator.service.ExpressionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
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

    @PostMapping(path = "/calculate/sub", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CalculateExpressionDtoResponse calcSubtraction(@CookieValue("JAVASESSIONID") String sessionId, @RequestBody ExpressionSubtractionDtoRequest request) throws ServerException {
        return expressionService.calculate(request.getX() + "-" + request.getY(), Type.SUBTRACTION, sessionId);
    }

    @PostMapping(path = "/calculate/div", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CalculateExpressionDtoResponse calcDivision(@CookieValue("JAVASESSIONID") String sessionId, @Validated @RequestBody ExpressionDivisionDtoRequest request) throws ServerException {
        return expressionService.calculate(request.getX() + "/" + request.getY(), Type.DIVISION, sessionId);
    }

    @PostMapping(path = "/calculate/mul", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CalculateExpressionDtoResponse calcMultiplication(@CookieValue("JAVASESSIONID") String sessionId, @RequestBody ExpressionMultiplicationDtoRequest request) throws ServerException {
        return expressionService.calculate(request.getX() + "*" + request.getY(), Type.MULTIPLICATION, sessionId);
    }

    @PostMapping(path = "/calculate/exp", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CalculateExpressionDtoResponse calcExponentiation(@CookieValue("JAVASESSIONID") String sessionId, @RequestBody ExpressionExponentiationDtoRequest request) throws ServerException {
        return expressionService.calculate("Math.pow(" + request.getX() + "," + request.getY() + ")", Type.MULTIPLICATION, sessionId);
    }

    @PostMapping(path = "/calculate/sin", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CalculateExpressionDtoResponse calcSinus(@CookieValue("JAVASESSIONID") String sessionId, @RequestBody ExpressionSinusDtoRequest request) throws ServerException {
        return expressionService.calculate("Math.sin(" + request.getX() + ")", Type.MULTIPLICATION, sessionId);
    }

    @PostMapping(path = "/calculate/complex", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CalculateExpressionDtoResponse calcComplex(@CookieValue("JAVASESSIONID") String sessionId, @RequestBody ExpressionComplexDtoRequest request) throws ServerException {
        return expressionService.calculate(request.getExpression(), Type.MULTIPLICATION, sessionId);
    }
}
