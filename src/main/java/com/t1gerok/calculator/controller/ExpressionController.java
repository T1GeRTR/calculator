package com.t1gerok.calculator.controller;

import com.t1gerok.calculator.exception.ServerException;
import com.t1gerok.calculator.model.Type;
import com.t1gerok.calculator.request.*;
import com.t1gerok.calculator.response.CalculateExpressionDtoResponse;
import com.t1gerok.calculator.response.GetByDateTimeExpressionDtoResponse;
import com.t1gerok.calculator.response.GetByTypeExpressionDtoResponse;
import com.t1gerok.calculator.response.GetByUserIdExpressionDtoResponse;
import com.t1gerok.calculator.service.ExpressionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class ExpressionController {
    @Autowired
    private ExpressionService expressionService;

    @PostMapping(path = "/expression/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CalculateExpressionDtoResponse calcAddition(@CookieValue("JAVASESSIONID") String sessionId, @RequestBody ExpressionAdditionDtoRequest request) throws ServerException {
        return expressionService.calculate(request.getX() + "+" + request.getY(), Type.ADDITION, sessionId);
    }

    @PostMapping(path = "/expression/sub", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CalculateExpressionDtoResponse calcSubtraction(@CookieValue("JAVASESSIONID") String sessionId, @RequestBody ExpressionSubtractionDtoRequest request) throws ServerException {
        return expressionService.calculate(request.getX() + "-" + request.getY(), Type.SUBTRACTION, sessionId);
    }

    @PostMapping(path = "/expression/div", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CalculateExpressionDtoResponse calcDivision(@CookieValue("JAVASESSIONID") String sessionId, @Validated @RequestBody ExpressionDivisionDtoRequest request) throws ServerException {
        return expressionService.calculate(request.getX() + "/" + request.getY(), Type.DIVISION, sessionId);
    }

    @PostMapping(path = "/expression/mul", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CalculateExpressionDtoResponse calcMultiplication(@CookieValue("JAVASESSIONID") String sessionId, @RequestBody ExpressionMultiplicationDtoRequest request) throws ServerException {
        return expressionService.calculate(request.getX() + "*" + request.getY(), Type.MULTIPLICATION, sessionId);
    }

    @PostMapping(path = "/expression/complex", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CalculateExpressionDtoResponse calcComplex(@CookieValue("JAVASESSIONID") String sessionId, @RequestBody ExpressionComplexDtoRequest request) throws ServerException {
        return expressionService.calculate(request.getExpression(), Type.COMPLEX, sessionId);
    }

    @GetMapping(path = "/expression/{type}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<GetByTypeExpressionDtoResponse> getByType(@PathVariable("type") Type type) throws ServerException {
        return expressionService.getByType(type);
    }

    @GetMapping(path = "/expressions/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<GetByDateTimeExpressionDtoResponse> getByDateTime(@RequestParam LocalDateTime from, @RequestParam LocalDateTime to) throws ServerException {
        return expressionService.getByDateTime(from,to);
    }

    @GetMapping(path = "/expressions/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<GetByUserIdExpressionDtoResponse> getByUserId(@RequestParam int userId) throws ServerException {
        return expressionService.getByUserId(userId);
    }
}
