package com.hz.dao;

import org.springframework.stereotype.Repository;

/**
 * @author hz
 * @Description:
 * @create 2020-09-08
 */
@Repository("orderDao")
public class OrderDaoImpl implements OrderDao {
    @Override
    public void orderWriter() {
        System.out.println("order");
    }
}
