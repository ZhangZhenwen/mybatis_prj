package com.zhenwen.mybatis.sqlsession;

import com.zhenwen.mybatis.config.Configuration;
import com.zhenwen.mybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import com.zhenwen.mybatis.utils.XmlConfigBuilder;

import java.io.InputStream;

/**
 * created by IntelliJ IDEA
 *
 * @author zhenwen
 * @version jdk 11
 * @date 2020/3/29
 */

public class SqlSessionFactoryBuilder {

    /**
     * 根据参数的字节输入流来创建一个SqlSessionFactory工厂
     * @param config
     * @return
     */
    public SqlSessionFactory build(InputStream config) {
        Configuration cfg = XmlConfigBuilder.loadConfiguration(config);
        return new DefaultSqlSessionFactory(cfg);
    }
}
