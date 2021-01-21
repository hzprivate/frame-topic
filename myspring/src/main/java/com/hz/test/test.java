package com.hz.test;

import com.hz.BeanFactory;
import com.hz.dao.UserDao;
import com.hz.service.UserService;
import com.hz.service.UserServiceImpl;

/**
 * @author hz
 * @create 2020-09-21
 */
public class test {
    public static void main(String[] args) {
        BeanFactory beanFactory = new BeanFactory();

        //试验垃圾版 人为set方法注入
//        UserService userService = new UserServiceImpl();
//        UserDao userDao =(UserDao) beanFactory.getBean("userDao");
//        ((UserServiceImpl) userService).setUserDao(userDao);
//        userService.query();

        //试验 xml set注入 或 构造器注入
        UserService userService =(UserService) beanFactory.getBean("userService");
        userService.query();

    }
}
