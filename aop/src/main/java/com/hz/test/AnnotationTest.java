package com.hz.test;

import com.hz.annotiton.Entity;
import com.hz.app.AppConfig;
import com.hz.dao.OrderDao;
import com.hz.dao.QueryDao;
import com.hz.entity.City;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author hz
 * @Description:测试注解
 * @create 2020-09-07
 */
public class AnnotationTest {
    /**
     * 测试注解
     * @param args
     */
//    public static void main(String[] args) {
//        Class<City> cityClass = City.class;
//        boolean annotationPresent = cityClass.isAnnotationPresent(Entity.class);
//        System.out.println(annotationPresent);
//        if(annotationPresent){
//            Entity annotation = cityClass.getAnnotation(Entity.class);
//            System.out.println(annotation.name());
//        }
//
//
//    }

//    /**
//     * 测试 aop 拦截
//     * @param args
//     */
//    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context =
//                new AnnotationConfigApplicationContext(AppConfig.class);
//        QueryDao bean = context.getBean(QueryDao.class);
//        bean.query();
//
//    }

    /**
     * 测试 引入 introduction @DeclareParents
     * @param args
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        OrderDao bean = (OrderDao) context.getBean("testDao");
        bean.orderWriter();

    }
}
