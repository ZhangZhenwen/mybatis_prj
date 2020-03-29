package com.zhenwen.mybatis.sqlsession.defaults;

import com.zhenwen.mybatis.config.Configuration;
import com.zhenwen.mybatis.sqlsession.proxy.MapperProxy;
import com.zhenwen.mybatis.sqlsession.SqlSession;
import com.zhenwen.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * created by IntelliJ IDEA
 *
 * @author zhenwen
 * @version jdk 11
 * @date 2020/3/29
 *
 * SqlSession接口的实现类
 */

public class DefaultSqlSession implements SqlSession {

    private Configuration cfg;
    private Connection conn;

    public DefaultSqlSession(Configuration cfg) {
        this.cfg = cfg;
        this.conn = DataSourceUtil.getConnection(cfg);
    }

    @Override
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(), new Class[]{daoInterfaceClass},
                new MapperProxy(cfg.getMappers(), conn));
    }

    @Override
    public void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
