//package com.hz.web;
//
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRegistration;
//
///**
// * @author hz
// * @create 2020-12-28
// */
//public class MyWebApplicationInitializer implements WebApplicationInitializer {
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//
//        // Load Spring web application configuration
//        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//        context.refresh();
//        DispatcherServlet servlet = new DispatcherServlet(context);
//        ServletRegistration.Dynamic registration = servletContext.addServlet("websocket", servlet);
//        registration.setLoadOnStartup(1);
//        registration.addMapping("/");
//    }
//}
