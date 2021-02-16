package com.t1gerok.calculator.converter;

import com.t1gerok.calculator.model.Expression;
import com.t1gerok.calculator.response.GetByDateTimeExpressionDtoResponse;
import com.t1gerok.calculator.response.GetByTypeExpressionDtoResponse;
import com.t1gerok.calculator.response.GetByUserIdExpressionDtoResponse;

import java.util.ArrayList;
import java.util.List;

public class ExpressionConverter {
    public static List<GetByTypeExpressionDtoResponse> getByTypeDtoToModel(List<Expression> expressions) {
        List<GetByTypeExpressionDtoResponse> list = new ArrayList<>();
        for (Expression elem : expressions) {
            list.add(new GetByTypeExpressionDtoResponse(elem.getId(), elem.getType(), elem.getString(), elem.getResult(), elem.getStatus(), elem.getDatetime(), elem.getUser()));
        }
        return list;
    }

    public static List<GetByDateTimeExpressionDtoResponse> getByDateTimeDtoToModel(List<Expression> expressions) {
        List<GetByDateTimeExpressionDtoResponse> list = new ArrayList<>();
        for (Expression elem : expressions) {
            list.add(new GetByDateTimeExpressionDtoResponse(elem.getId(), elem.getType(), elem.getString(), elem.getResult(), elem.getStatus(), elem.getDatetime(), elem.getUser()));
        }
        return list;
    }

    public static List<GetByUserIdExpressionDtoResponse> getByUserIdDtoToModel(List<Expression> expressions) {
        List<GetByUserIdExpressionDtoResponse> list = new ArrayList<>();
        for (Expression elem : expressions) {
            list.add(new GetByUserIdExpressionDtoResponse(elem.getId(), elem.getType(), elem.getString(), elem.getResult(), elem.getStatus(), elem.getDatetime(), elem.getUser()));
        }
        return list;
    }
}
