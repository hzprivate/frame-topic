package com.hz;

import com.hz.web.MyWebApplicationInitializer;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.ServletException;
import java.io.File;

/**
 * @author hz
 * @Description:
 * @create 2020-12-24
 */


public class TestTomcat {
    public static void run() {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(9080);
        //获取项目编译后的claess 路径
//        String relativePath=System.getProperty("user.dir");
        String sourcePath = MyWebApplicationInitializer.class.getClass().getResource("/").getPath();
        //获取源代码文件路径
//        String webAppDirLocation=relativePath+"/simulate-springboot/src/main/webapp";
        //获取webapp 文件
//        String filePath = new File(webAppDirLocation).getAbsolutePath();
        StandardContext context = null;
        try {
            context = (StandardContext) tomcat.addWebapp("/",new File("simulate-springboot/src/main/webapp").getAbsolutePath());
        } catch (ServletException e) {
            e.printStackTrace();
        }
        //告诉tomcat，源码在哪里，得到Context
//        StandardContext context = (StandardContext )tomcat.addWebapp("/", filePath);
        //webResourceRoot 用于加载 项目的class文件
        WebResourceRoot webResourceRoot = new StandardRoot(context);
        //源码的路径webResourceRoot，发布后的路径/WEB-INF/classes，项目编译后的路径sourcePath
        webResourceRoot.addPreResources(new DirResourceSet(webResourceRoot,"/WEB-INF/classes",sourcePath,"/"));
        context.setResources(webResourceRoot);
        try {
            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
