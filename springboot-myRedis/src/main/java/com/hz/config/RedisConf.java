package com.hz.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author hz
 * @create 2021-01-13
 */
//@ConfigurationProperties
public class RedisConf {

    private String redis_ip;

    private int redis_port;

    private int redis_num;

    public String getRedis_ip() {
        return redis_ip;
    }

    public void setRedis_ip(String redis_ip) {
        this.redis_ip = redis_ip;
    }

    public int getRedis_port() {
        return redis_port;
    }

    public void setRedis_port(int redis_port) {
        this.redis_port = redis_port;
    }

    public int getRedis_num() {
        return redis_num;
    }

    public void setRedis_num(int redis_num) {
        this.redis_num = redis_num;
    }
}
