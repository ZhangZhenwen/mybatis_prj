package com.zhenwen.mybatis.sqlsession.proxy;

import com.zhenwen.mybatis.config.Mapper;
import com.zhenwen.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

/**
 * created by IntelliJ IDEA
 *
 * @author zhenwen
 * @version jdk 11
 * @date 2020/3/29
 */

public class MapperProxy implements InvocationHandler {

    private Map<String, Mapper> mappers;
    private Connection conn;

    public MapperProxy(Map<String, Mapper> mappers, Connection conn) {
        this.mappers = mappers;
        this.conn = conn;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        String methodName = method.getName();
        String className = method.getDeclaringClass().getName();

        String key = className + "." + methodName;
        Mapper mapper = mappers.get(key);

        if (mapper == null) {
            throw new IllegalArgumentException("Wrong argument!");
        }


        return new Executor().selectList(mapper, conn);
    }
}
