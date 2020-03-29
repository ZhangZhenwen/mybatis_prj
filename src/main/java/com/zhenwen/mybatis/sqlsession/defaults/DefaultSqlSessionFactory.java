package com.zhenwen.mybatis.sqlsession.defaults;

import com.zhenwen.mybatis.config.Configuration;
import com.zhenwen.mybatis.sqlsession.SqlSession;
import com.zhenwen.mybatis.sqlsession.SqlSessionFactory;

/**
 * created by IntelliJ IDEA
 *
 * @author zhenwen
 * @version jdk 11
 * @date 2020/3/29
 *
 * SqlSessionFactory接口的实现类
 */

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration cfg;

    public DefaultSqlSessionFactory(Configuration cfg) {
        this.cfg = cfg;
    }

    @Override
    public SqlSession openSession() {

        return new DefaultSqlSession(cfg);
    }
}
