package com.zhenwen.mybatis.io;

import java.io.InputStream;

/**
 * created by IntelliJ IDEA
 *
 * @author zhenwen
 * @version jdk 11
 * @date 2020/3/29
 */

public class Resources {

    /**
     * 获取一个字节流
     * @param filePath 文件路径
     * @return 字节流
     */
    public static InputStream getResourceAsStream(String filePath) {
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
