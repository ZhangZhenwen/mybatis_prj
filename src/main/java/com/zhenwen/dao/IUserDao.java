package com.zhenwen.dao;

import com.zhenwen.domain.User;
import com.zhenwen.mybatis.annotations.Select;

import java.util.List;

/**
 * created by IDEA 2018.3
 *
 * @author Zhang Zhenwen
 * @date 15:49 2020/1/26
 * @since JDK1.8
 */

public interface IUserDao {

    /**
     * 查找所有信息
     * @return User对象
     */
    @Select("select * from user")
    List<User> findAll();
}
