package com.luban;

import com.luban.config.Spring;
import com.luban.service.IndexService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hz
 * @Description:
 * @create 2020-08-10
 */
public class Test {
//    1.基于xml的获取bean对象
//    public static void main(String[] args) {
//        ClassPathXmlApplicationContext classPathXmlApplicationContext
//                =new ClassPathXmlApplicationContext("classpath:spring.xml");
//        IndexService service = (IndexService) classPathXmlApplicationContext.getBean("indexService");
//
//        service.serviceTest();
//    }

//        2.基于配置类的获取bean对象
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext
                =new AnnotationConfigApplicationContext(Spring.class);
        IndexService service = (IndexService) applicationContext.getBean("indexService");

        service.serviceHashCode();
    }
}
