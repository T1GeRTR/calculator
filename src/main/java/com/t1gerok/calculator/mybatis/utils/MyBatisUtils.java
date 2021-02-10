package com.t1gerok.calculator.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Reader;

public class MyBatisUtils {

    private static SqlSessionFactory sqlSessionFactory;
    private static final Logger LOGGER = LoggerFactory.getLogger(MyBatisUtils.class);
    private static boolean initIsDone = false;

    public static boolean initSqlSessionFactory() {
        try (Reader reader = Resources.getResourceAsReader("mybatis-config.xml")) {
            if (!initIsDone) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

                initIsDone = true;
            }
            return true;
        } catch (Exception e) {
            LOGGER.error("Error loading mybatis-config.xml", e);
            return false;
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

}