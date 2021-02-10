package com.t1gerok.calculator.mybatis.mappers;

import com.t1gerok.calculator.model.Expression;
import com.t1gerok.calculator.model.Session;
import com.t1gerok.calculator.model.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

public interface ExpressionMapper {

    @Insert({"INSERT INTO expression (type, string, result, status, datetime, userId) VALUES " +
            "(#{expression.type}, #{expression.string}, #{expression.result}, #{expression.status}, #{expression.datetime}, #{userId})"})
    @Options(useGeneratedKeys = true, keyProperty = "expression.id")
    Expression insert(@Param("expression") Expression expression, @Param("userId") int userId);

    @Select({"SELECT * FROM expression WHERE type = #{sessionId}"})
    @Results({
            @Result(property = "user", column = "userId", javaType = User.class,
                    one = @One(select = "com.t1gerok.calculator.mybatis.mappers.UserMapper.getById", fetchType = FetchType.EAGER))})
    Session getByType(@Param("sessionId") String sessionId);

    

}
