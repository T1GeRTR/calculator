package com.t1gerok.calculator.mybatis.daoimpl;


import com.t1gerok.calculator.mybatis.mappers.ExpressionMapper;
import com.t1gerok.calculator.mybatis.mappers.UserMapper;
import com.t1gerok.calculator.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

public class DaoImplBase {

    protected SqlSession getSession() {
        MyBatisUtils.initSqlSessionFactory();
        return MyBatisUtils.getSqlSessionFactory().openSession();
    }

    protected UserMapper getUserMapper(SqlSession sqlSession) {
        return sqlSession.getMapper(UserMapper.class);
    }

    protected ExpressionMapper getExpressionMapper(SqlSession sqlSession) {
        return sqlSession.getMapper(ExpressionMapper.class);
    }
}