package com.hz;

import com.hz.app.Appconfig;
import com.hz.dao.UserDao;
import com.hz.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//import com.hz.service.UserService;
import java.util.List;
import java.util.Map;

/**
 * @author hz
 * @create 2020-11-16
 */
public class test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        context.register(Appconfig.class);
        context.refresh();
        UserService userService = (UserService) context.getBean("userService");
        List<Map> list = userService.getList();
        List<Map> list1 = userService.getList();
//        UserDao userDao = (UserDao) context.getBean("userDao");
//        UserDao userDao1 = (UserDao) context.getBean("userDao");


    }

}
