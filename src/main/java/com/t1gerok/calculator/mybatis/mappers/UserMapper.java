package com.t1gerok.calculator.mybatis.mappers;

import com.t1gerok.calculator.model.Session;
import com.t1gerok.calculator.model.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

public interface UserMapper {

    @Insert({"INSERT INTO session (sessionId, userId) VALUES (#{sessionId}, (SELECT id FROM user WHERE login = #{login} AND password = #{password}))"})
    void login(@Param("login") String login, @Param("password") String password, @Param("sessionId") String sessionId);

    @Delete({"DELETE FROM session WHERE sessionId = #{sessionId}"})
    Integer logout(@Param("sessionId") String sessionId);

    @Insert({"INSERT INTO user (login, password) VALUES (#{user.login}, #{user.password})"})
    @Options(useGeneratedKeys = true, keyProperty = "user.id")
    void insertUser(@Param("user") User user);

    @Select({"SELECT * FROM user WHERE id = (SELECT userId FROM session WHERE sessionId = #{session})"})
    User getBySession(String session);

    @Select({"SELECT * FROM user WHERE id = #{userId}"})
    User getById(int userId);

    @Select({"SELECT * FROM session WHERE sessionId = #{sessionId}"})
    @Results({
            @Result(property = "sessionId", column = "sessionId"),
            @Result(property = "user", column = "sessionId", javaType = Session.class,
                    one = @One(select = "com.t1gerok.calculator.mybatis.mappers.UserMapper.getBySession", fetchType = FetchType.EAGER))})
    Session getSession(@Param("sessionId") String sessionId);
}
