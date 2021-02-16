package com.t1gerok.calculator.Service;

import com.t1gerok.calculator.exception.ServerException;
import com.t1gerok.calculator.model.Type;
import com.t1gerok.calculator.response.CalculateExpressionDtoResponse;
import com.t1gerok.calculator.service.ExpressionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestExpressionService {
    ExpressionService service = new ExpressionService();

    @Test
    public void testCalculate() throws ServerException {
        CalculateExpressionDtoResponse response = service.calculate("2+2", Type.ADDITION, "123456Admin");
        System.out.println(response.getResult());
        Assertions.assertEquals(response.getResult(),4);
    }
}
