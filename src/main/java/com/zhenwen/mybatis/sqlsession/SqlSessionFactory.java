package com.zhenwen.mybatis.sqlsession;

/**
 * created by IntelliJ IDEA
 *
 * @author zhenwen
 * @version jdk 11
 * @date 2020/3/29
 */

public interface SqlSessionFactory {

    /**
     * 打开一个Session对象
     * @return Session对象
     */
    SqlSession openSession();
}
