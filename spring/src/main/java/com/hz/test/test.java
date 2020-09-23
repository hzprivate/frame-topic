package com.hz.test;

import com.hz.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author hz
 * @create 2020-09-23
 */
public class test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        //获取getObject中方法返回的对象(调用才会产生)
//        Object myFactoryBean = context.getBean("myFactoryBean");
//        //获取类当前对象
//        Object myFactoryBean1 = context.getBean("&myFactoryBean");
//        System.out.println(myFactoryBean);
//        System.out.println(myFactoryBean1);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }

}
