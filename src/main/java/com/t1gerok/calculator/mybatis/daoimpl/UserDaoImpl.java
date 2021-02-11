package com.t1gerok.calculator.mybatis.daoimpl;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import com.t1gerok.calculator.dao.UserDao;
import com.t1gerok.calculator.exception.ErrorCode;
import com.t1gerok.calculator.exception.ServerException;
import com.t1gerok.calculator.model.Session;
import com.t1gerok.calculator.model.User;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDaoImpl extends DaoImplBase implements UserDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public User insert(User user) throws ServerException {
        LOGGER.debug("DAO insert");
        try (SqlSession sqlSession = getSession()) {
            try {
                getUserMapper(sqlSession).insert(user);
            } catch (RuntimeException e) {
                LOGGER.debug("Can't insert admin {}", user, e);
                sqlSession.rollback();
                if (e.getCause() instanceof MySQLIntegrityConstraintViolationException) {
                    throw new ServerException(ErrorCode.DUPLICATE_LOGIN, user.getLogin());
                }
                throw new ServerException(ErrorCode.DATABASE_ERROR);
            }
            sqlSession.commit();
        }
        return user;
    }

    @Override
    public Session login(String login, String password, Session session) throws ServerException {
        LOGGER.debug("DAO login");
        try (SqlSession sqlSession = getSession()) {
            try {
                User user = getUserMapper(sqlSession).getByLogin(login);
                if (user == null) {
                    throw new ServerException(ErrorCode.CANT_LOGIN, login);
                }
                if (!user.getPassword().equals(password)) {
                    throw new ServerException(ErrorCode.WRONG_PASSWORD);
                }
                getUserMapper(sqlSession).login(login, password, session.getSessionId());
                session = getUserMapper(sqlSession).getSession(session.getSessionId());
            } catch (RuntimeException e) {
                LOGGER.debug("Can't login user: {}", login, e);
                sqlSession.rollback();
                throw new ServerException(ErrorCode.DATABASE_ERROR);
            }
            sqlSession.commit();
        }
        return session;
    }

    @Override
    public boolean logout(String sessionId) throws ServerException {
        LOGGER.debug("DAO logout");
        try (SqlSession sqlSession = getSession()) {
            try {
                if (getUserMapper(sqlSession).logout(sessionId) == 0) {
                    throw new ServerException(ErrorCode.CANT_LOGOUT);
                }
            } catch (RuntimeException e) {
                LOGGER.debug("Can't logout user", e);
                sqlSession.rollback();
                throw new ServerException(ErrorCode.DATABASE_ERROR);
            }
            sqlSession.commit();
        }
        return true;
    }

    @Override
    public User getBySessionId(String sessionId) throws ServerException {
        LOGGER.debug("DAO get");
        try (SqlSession sqlSession = getSession()) {
            try {
                User user = getUserMapper(sqlSession).getBySession(sessionId);
                if (user == null) {
                    throw new ServerException(ErrorCode.CANT_GET_USER_BY_SESSION);
                }
                return user;
            } catch (RuntimeException e) {
                LOGGER.debug("Can't get by javaSessionId: {}", sessionId, e);
                throw new ServerException(ErrorCode.DATABASE_ERROR);
            }
        }
    }
}
