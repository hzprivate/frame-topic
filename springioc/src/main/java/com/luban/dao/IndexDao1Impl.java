package com.luban.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * @author hz
 * @Description:
 * @create 2020-08-10
 */

@Repository
@Scope("prototype")
public class IndexDao1Impl implements IndexDao {
    @Override
    public void testDao() {
        System.out.println("daoImpl");
    }
}
