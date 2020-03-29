package com.zhenwen.mybatis.config;

import java.util.HashMap;
import java.util.Map;

/**
 * created by IntelliJ IDEA
 *
 * @author zhenwen
 * @version jdk 11
 * @date 2020/3/29
 * <p>
 * 自定义Mybatis的配置类
 */

public class Configuration {

    private String driver;
    private String url;
    private String username;
    private String password;

    private Map<String, Mapper> mappers;

    public Configuration() {
        mappers = new HashMap<>();
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<String, Mapper> getMappers() {
        return mappers;
    }

    public void setMappers(Map<String, Mapper> mappers) {
        this.mappers.putAll(mappers);
    }
}
