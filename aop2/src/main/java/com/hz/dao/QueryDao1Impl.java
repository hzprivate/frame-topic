package com.hz.dao;

import org.springframework.stereotype.Repository;

/**
 * @author hz
 * @Description:
 * @create 2020-11-20
 */
@Repository
public class QueryDao1Impl implements QueryDao {
    @Override
    public void getData() {
        System.out.println("QueryDao1Impl。。。。1111");
    }
}
