package com.hz.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author hz
 * @Description:
 * @create 2020-12-24
 */
public class MybootServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //得到静态资源后缀"/index.jsp或者/index.html"，由于这些文件内容在编译后都会放在classpath下。
        // 因此得到classpath也是必须的
        String fileName=request.getRequestURI();
        //得到classpath
        String basePath=MybootServlet.class.getResource("/").getPath();
        //拼出来文件路径完整路径，此时我们拿到的类似于D:/项目名/src/java/main/index.html这样的
        String filePath=basePath+fileName;
        //构造一个file对象，把静态资源读到file对象里
        File file=new File(filePath);
        //InputStream读入内存
        InputStream inputStream=new FileInputStream(file);
        byte[] bytes = new byte[1024];
        inputStream.read(bytes);
        inputStream.close();
        //创建相应内容
        String str=new String(bytes);
        //设置响应内容
        response.setContentType("text/html");
        //写出去
        response.getWriter().write(str);
    }
}
