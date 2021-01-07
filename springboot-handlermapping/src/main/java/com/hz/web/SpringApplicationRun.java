package com.hz.web;

import com.hz.app.AppConfig;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;

/**
 * @author hz
 * @Description:
 * @create 2020-12-24
 */


public class SpringApplicationRun {

    public static void main(String[] args) {
        //直接初始化 spring环境
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(AppConfig.class);
        context.refresh();


        //加载tomcat 初始化web环境
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(9080);
        File base = new File(System.getProperty("user.dir"));
        //addWebapp  可以初始化  WebApplicationInitializer实现类。
        //        StandardContext context = (StandardContext )tomcat.addWebapp("/", filePath);

        //但是 addContext  无法初始化 WebApplicationInitializer实现类。
        Context ctx = (Context) tomcat.addContext("/", base.getAbsolutePath());

        DispatcherServlet servlet = new DispatcherServlet(context);
        Tomcat.addServlet(ctx,"hzDemo",servlet).setLoadOnStartup(1);
        ctx.addServletMapping("/","hzDemo");
        try {
            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
