package com.zhenwen.dao;

import com.zhenwen.domain.QueryVo;
import com.zhenwen.domain.User;

import java.util.List;

/**
 * created by IDEA 2018.3
 *
 * @author Zhang Zhenwen
 * @date 15:49 2020/1/26
 * @since JDK1.8
 */

public interface UserDao {

    /**
     * 查找所有信息
     *
     * @return User对象
     */
    List<User> findAll();

    /**
     * 保存用户
     *
     * @param user 用户对象
     */
    void saveUser(User user);

    /**
     * 更新用户
     *
     * @param user 用户对象
     */
    void updateUser(User user);

    /**
     * 删除用户
     *
     * @param id 用户对象Id
     */
    void deleteUser(Integer id);

    /**
     * 通过id查询用户
     *
     * @param id 要查询的用户Id
     * @return 用户对象
     */
    User findById(Integer id);

    /**
     * 根据名称模糊查询
     *
     * @param name 用户名称
     * @return 用户列表
     */
    List<User> findByName(String name);

    /**
     * 查询user表的总数
     *
     * @return 总数
     */
    int findTotal();

    /**
     * 根据queryVo中的查询条件查询结果
     *
     * @param vo 查询类
     * @return 用户对象
     */
    List<User> findUserByVo(QueryVo vo);
}














