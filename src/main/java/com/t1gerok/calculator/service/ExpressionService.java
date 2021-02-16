package com.t1gerok.calculator.service;

import com.t1gerok.calculator.converter.ExpressionConverter;
import com.t1gerok.calculator.dao.ExpressionDao;
import com.t1gerok.calculator.dao.UserDao;
import com.t1gerok.calculator.exception.ServerException;
import com.t1gerok.calculator.model.Expression;
import com.t1gerok.calculator.model.Status;
import com.t1gerok.calculator.model.Type;
import com.t1gerok.calculator.model.User;
import com.t1gerok.calculator.mybatis.daoimpl.ExpressionDaoImpl;
import com.t1gerok.calculator.mybatis.daoimpl.UserDaoImpl;
import com.t1gerok.calculator.response.CalculateExpressionDtoResponse;
import com.t1gerok.calculator.response.GetByDateTimeExpressionDtoResponse;
import com.t1gerok.calculator.response.GetByTypeExpressionDtoResponse;
import com.t1gerok.calculator.response.GetByUserIdExpressionDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExpressionService {
    @Autowired
    private ExpressionDao expressionDao;
    @Autowired
    private UserDao userDao;

    public CalculateExpressionDtoResponse calculate(String string, Type type, String sessionId) throws ServerException {
        User user = userDao.getBySessionId(sessionId);
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        float result = 0;
        Status status;
        try {
            result = (int) engine.eval(string);
            status = Status.OK;
        } catch (ScriptException e) {
            status = Status.ERROR;
            e.printStackTrace();
        }
        Expression expression = expressionDao.insert(new Expression(type, string, result, status, LocalDateTime.now(), user));
        return new CalculateExpressionDtoResponse(expression.getId(), expression.getType(), expression.getString(), expression.getResult(), expression.getStatus(), expression.getDatetime(), expression.getUser());
    }

    public List<GetByTypeExpressionDtoResponse> getByType(Type type) throws ServerException {
        return ExpressionConverter.getByTypeDtoToModel(expressionDao.getByType(type));
    }

    public List<GetByDateTimeExpressionDtoResponse> getByDateTime(LocalDateTime from, LocalDateTime to) throws ServerException {
        return ExpressionConverter.getByDateTimeDtoToModel(expressionDao.getByDateTime(from, to));
    }

    public List<GetByUserIdExpressionDtoResponse> getByUserId(int userId) throws ServerException {
        return ExpressionConverter.getByUserIdDtoToModel(expressionDao.getByUserId(userId));
    }
}
