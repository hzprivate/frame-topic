package com.hz.service;

import com.hz.dao.UserDao;

/**
 * @author hz
 * @create 2020-09-21
 */
public class UserServiceImpl implements UserService {
    UserDao userDao;

    //constructor-arg 即 构造器注入
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void query() {
        System.out.println("service...");
        userDao.query();
    }

    // property  即 setter注入
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

}
