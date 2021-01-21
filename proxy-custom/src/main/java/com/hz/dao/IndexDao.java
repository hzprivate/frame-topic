package com.hz.dao;

import org.springframework.stereotype.Service;

/**
 * 测试 cglib代理
 * @author hz
 * @Description:
 * @create 2020-11-07
 */
@Service
public class IndexDao {
    public void query(){
        System.out.println("indexDao...");
    }
}
