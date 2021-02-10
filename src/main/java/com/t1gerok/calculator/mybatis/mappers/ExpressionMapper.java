package com.t1gerok.calculator.mybatis.mappers;

import com.t1gerok.calculator.model.Expression;
import com.t1gerok.calculator.model.Session;
import com.t1gerok.calculator.model.Type;
import com.t1gerok.calculator.model.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.time.LocalDateTime;
import java.util.List;

public interface ExpressionMapper {

    @Insert({"INSERT INTO expression (type, string, result, status, datetime, userId) VALUES " +
            "(#{expression.type}, #{expression.string}, #{expression.result}, #{expression.status}, #{expression.datetime}, #{userId})"})
    @Options(useGeneratedKeys = true, keyProperty = "expression.id")
    Expression insert(@Param("expression") Expression expression, @Param("userId") int userId);

    @Select({"SELECT * FROM expression WHERE type = #{type}"})
    @Results({
            @Result(property = "user", column = "userId", javaType = User.class,
                    one = @One(select = "com.t1gerok.calculator.mybatis.mappers.UserMapper.getById", fetchType = FetchType.EAGER))})
    List<Expression> getByType(@Param("type") Type type);

    @Select({"SELECT * FROM expression WHERE datetime => #{from} AND datetime =< #{to}"})
    @Results({
            @Result(property = "user", column = "userId", javaType = User.class,
                    one = @One(select = "com.t1gerok.calculator.mybatis.mappers.UserMapper.getById", fetchType = FetchType.EAGER))})
    List<Expression> getByDateTime(@Param("from") LocalDateTime from, @Param("to") LocalDateTime to);

    @Select({"SELECT * FROM expression WHERE type = #{userId}"})
    @Results({
            @Result(property = "user", column = "userId", javaType = User.class,
                    one = @One(select = "com.t1gerok.calculator.mybatis.mappers.UserMapper.getById", fetchType = FetchType.EAGER))})
    List<Expression> getByUserId(@Param("userId") int userId);

}
