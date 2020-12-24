package com.hz;

import com.hz.web.MyWebApplicationInitializer;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletRegistration;
import javax.servlet.annotation.HandlesTypes;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author hz
 * @Description:
 * @create 2020-12-24
 */


public class TestTomcat {
    public static void run() {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8090);
        //获取项目编译后的claess 路径
        String path = MyWebApplicationInitializer.class.getClass().getResource("/").getPath();
        path="/target/classes";
        //获取webapp 文件
        String filePath = new File("src/main/webapp").getAbsolutePath();
        Context context = tomcat.addWebapp("/", filePath);
        //webResourceRoot 用于加载 项目的class文件
        WebResourceRoot webResourceRoot = new StandardRoot(context);
        webResourceRoot.addPreResources(new DirResourceSet(webResourceRoot,"/WEB-INF/classes",path,"/"));
        try {
            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
