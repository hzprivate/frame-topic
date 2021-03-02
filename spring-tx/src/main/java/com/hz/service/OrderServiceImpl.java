package com.hz.service;

import com.hz.dao.OrderDao;
import com.hz.dao.UserDao;
import com.nbaisino.redis.RedisClient;
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
//@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;
    @Autowired
    UserDao userDao;
    @Override
    public void updateOrder(){
        System.out.println("开始执行 update表修改");
        userDao.updateUser();
        System.out.println("修改 update表完成");
//        orderDao.insertOrder();
//        int i= 1/0;
    }
    @Override
    public void insertUser(){
        userDao.insertUser();
        System.out.println("执行完成--user");
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public void selectUser() {
        //执行正常
        System.out.println(Thread.currentThread().getName()+",开始陷入线程阻塞");
        try {
            Thread.sleep(1000*40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
