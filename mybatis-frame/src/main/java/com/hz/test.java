package com.hz;

import com.hz.app.AppConfig;
import com.hz.dao.UserDao;
//import com.hz.service.UserService;
//import com.hz.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;


/**
 * @author hz
 * @create 2020-11-16
 */
public class test {
    /**
     * 使用 mybatis-spring 调用sql，调用mapper获取数据时，调用几次，sql打印几次，一级缓存失效
     */
    @Test
    public void test1() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();

        //激活 mybatisSpring dataSourceCompany
        context.register(AppConfig.class);
        context.getEnvironment().setActiveProfiles("mybatisSpring", "dataSourceCompany");
        context.refresh();

//        UserService userService = (UserService) context.getBean("userService");
//        List<Map> list = userService.getList();
//        List<Map> list1 = userService.getList();

//        System.out.println("打印结果：" + list);

    }

    /**
     * 使用 mybatis 调用sql，调用mapper获取数据时，不管调用几次，只打印一次sql，一级缓存缓存起作用
     * 测试时，把 UserService.java文件代码注释
     */
    @Test
    public void test2() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();

        //激活 mybatis dataSourceCompany
        context.register(AppConfig.class);
        context.getEnvironment().setActiveProfiles("mybatis", "dataSourceCompany");
        context.refresh();

        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) context.getBean("sqlSessionFactory");
        //try-with-resource块，自动关闭资源。
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserDao mapper = session.getMapper(UserDao.class);
            List<Map> list = mapper.getList();
            List<Map> list1 = mapper.getList();
            System.out.println("打印结果：" + list);
        }

    }


}
