package com.zhenwen.test;

import com.zhenwen.dao.UserDao;
import com.zhenwen.domain.QueryVo;
import com.zhenwen.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * created by IDEA 2018.3
 *
 * @author Zhang Zhenwen
 * @date 17:48 2020/1/30
 * @since JDK1.8
 */

public class MybatisTest {

    private InputStream in;
    private SqlSession session;
    private UserDao userDao;

    /**
     * 初始化操作
     */
    @Before
    public void init() {
        // 1. 读取配置文件
        try {
            in = Resources.getResourceAsStream("SqlMapConfig.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 2. 创建一个SqlSessionFactory
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);

        // 3. 使用工厂生产一个SqlSession对象
        session = factory.openSession();

        // 4. 使用SqlSession创建Dao接口的代理对象
        userDao = session.getMapper(UserDao.class);
    }

    /**
     * 关闭连接
     */
    @After
    public void destroy() {
        //提交事务
        session.commit();

        //关闭连接
        try {
            session.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll() {
        // 5. 使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试保存
     */
    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("mybatis insert id");
        user.setAddress("福建省福州市");
        user.setBirthday(new Date());
        user.setSex("男");

        System.out.println(user);
        userDao.saveUser(user);
        System.out.println(user);
    }

    /**
     * 测试更新
     */
    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(50);
        user.setUsername("mybatis Update");
        user.setAddress("福建省福州市");
        user.setBirthday(new Date());
        user.setSex("女");

        userDao.updateUser(user);
    }

    /**
     * 测试删除
     */
    @Test
    public void testDelete() {
        userDao.deleteUser(51);
    }

    /**
     * 测试查询 根据id查询
     */
    @Test
    public void testFindById() {
        User user = userDao.findById(50);
        System.out.println(user);

    }

    /**
     * 测试查询 通过名字模糊查询
     */
    @Test
    public void testFindByName() {
        List<User> users = userDao.findByName("%王%");

        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试查询总记录条数
     */
    @Test
    public void testFindTotal() {
        int count = userDao.findTotal();
        System.out.println(count);

    }

    /**
     * 测试查询 通过查询类查询
     */
    @Test
    public void testFindUserByVo() {
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        vo.setUser(user);

        List<User> users = userDao.findUserByVo(vo);

        for (User u : users) {
            System.out.println(u);
        }
    }
}
