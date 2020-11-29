package com.hz.dao;

import org.springframework.stereotype.Repository;

/**
 * @author hz
 * @Description:
 * @create 2020-11-20
 */
@Repository
public class QueryDao2Impl implements QueryDao {
    @Override
    public void getData() {
        System.out.println("QueryDao2Impl。。。。2222");
    }
}
