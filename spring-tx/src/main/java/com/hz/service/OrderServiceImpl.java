package com.hz.service;

import com.hz.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hz
 * @Description:
 * @create 2021-01-18
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;
    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW)
    public void insertOrder() {
        orderDao.insertOrder();
        int i= 1/0;
    }
}
