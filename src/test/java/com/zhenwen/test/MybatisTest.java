package com.zhenwen.test;

import com.zhenwen.dao.IUserDao;
import com.zhenwen.domain.User;
import com.zhenwen.mybatis.io.Resources;
import com.zhenwen.mybatis.sqlsession.SqlSession;
import com.zhenwen.mybatis.sqlsession.SqlSessionFactory;
import com.zhenwen.mybatis.sqlsession.SqlSessionFactoryBuilder;


import java.io.InputStream;
import java.util.List;

/**
 * created by IDEA 2018.3
 *
 * @author Zhang Zhenwen
 * @date 17:48 2020/1/30
 * @since JDK1.8
 */

public class MybatisTest {
    public static void main(String[] args) throws Exception {
        // 1. 读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

        // 2. 创建一个SqlSessionFactory
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);

        // 3. 使用工厂生产一个SqlSession对象
        SqlSession session = factory.openSession();

        // 4. 使用SqlSession创建Dao接口的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);

        // 5. 使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }

        // 6. 释放资源
        session.close();
        in.close();
    }
}
