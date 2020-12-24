package com.hz.web;

import com.hz.app.AppConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

/**
 * tomcat 源码内部 循环执行 实现WebApplicationInitializer的类  执行onStartup方法
 * @author hz
 * @Description:
 * @create 2020-12-24
 */
public class MyWebApplicationInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        System.out.println("=================");
////        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
////        context.register(AppConfig.class);
////        context.refresh();
//        DispatcherServlet servlet = new DispatcherServlet(ctx);
//        ServletRegistration.Dynamic registration = ctx.addServlet("app", new MybootServlet());
//        registration.setLoadOnStartup(1);
//        registration.addMapping("/");

        ServletRegistration.Dynamic registration = ctx.addServlet("mybootServlet", new MybootServlet());
        registration.addMapping("/");
    }
}
