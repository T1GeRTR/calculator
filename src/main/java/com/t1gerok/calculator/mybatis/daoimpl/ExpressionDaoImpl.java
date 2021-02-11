package com.t1gerok.calculator.mybatis.daoimpl;

import com.t1gerok.calculator.dao.ExpressionDao;
import com.t1gerok.calculator.exception.ErrorCode;
import com.t1gerok.calculator.exception.ServerException;
import com.t1gerok.calculator.model.Expression;
import com.t1gerok.calculator.model.Type;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.List;

public class ExpressionDaoImpl extends DaoImplBase implements ExpressionDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public Expression insert(Expression expression, int userId) throws ServerException {
        LOGGER.debug("DAO insert");
        try (SqlSession sqlSession = getSession()) {
            try {
                getExpressionMapper(sqlSession).insert(expression, userId);
            } catch (RuntimeException e) {
                LOGGER.debug("Can't insert expression {}", expression, e);
                sqlSession.rollback();
                throw new ServerException(ErrorCode.DATABASE_ERROR);
            }
            sqlSession.commit();
        }
        return expression;
    }

    @Override
    public List<Expression> getByType(Type type) throws ServerException {
        LOGGER.debug("DAO get by type");
        List<Expression> expressions;
        try (SqlSession sqlSession = getSession()) {
            try {
                expressions = getExpressionMapper(sqlSession).getByType(type);
            } catch (RuntimeException e) {
                LOGGER.debug("Can't get expressions by type: {}", type, e);
                sqlSession.rollback();
                throw new ServerException(ErrorCode.DATABASE_ERROR);
            }
            sqlSession.commit();
        }
        return expressions;
    }

    @Override
    public List<Expression> getByDateTime(LocalDateTime from, LocalDateTime to) throws ServerException {
        LOGGER.debug("DAO get by type");
        List<Expression> expressions;
        try (SqlSession sqlSession = getSession()) {
            try {
                expressions = getExpressionMapper(sqlSession).getByDateTime(from, to);
            } catch (RuntimeException e) {
                LOGGER.debug("Can't get expressions by datetime to {} from {}", to, from, e);
                sqlSession.rollback();
                throw new ServerException(ErrorCode.DATABASE_ERROR);
            }
            sqlSession.commit();
        }
        return expressions;
    }

    @Override
    public List<Expression> getByUserId(int userId) throws ServerException {
        LOGGER.debug("DAO get by type");
        List<Expression> expressions;
        try (SqlSession sqlSession = getSession()) {
            try {
                expressions = getExpressionMapper(sqlSession).getByUserId(userId);
            } catch (RuntimeException e) {
                LOGGER.debug("Can't get expressions by userId: {}", userId, e);
                sqlSession.rollback();
                throw new ServerException(ErrorCode.DATABASE_ERROR);
            }
            sqlSession.commit();
        }
        return expressions;
    }
}
