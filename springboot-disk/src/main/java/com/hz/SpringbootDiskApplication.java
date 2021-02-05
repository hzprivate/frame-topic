package com.hz;

import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * @author hz
 * @create 2021-02-03
 */
public class SpringbootDiskApplication {
    public static void main(String[] args) {

        getInstanceNames();
//        AnnotationConfigApplicationContext context
//                =new AnnotationConfigApplicationContext(AppConfig.class);
    }
    private static void getInstanceNames() {
        // 获取ClassLoader
//        ClassLoader classLoader = SpringbootDiskApplication.class.getClassLoader();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        // Use names and ensure unique to protect against duplicates
        // 定义全路径List集合，即返回值 listClassName 是所有 classpath 下面的 META-INF/disk.factories 中定义的values
        List<String> listClassName = new ArrayList<>();
        Enumeration<URL> urls = null;
        try {
            urls = classLoader.getResources("META-INF/disk.factories");
            while(urls.hasMoreElements()){
                URL url = urls.nextElement();
                UrlResource resource = new UrlResource(url);
                //用spring-core 5.1.1包里现成方法
                Properties properties = PropertiesLoaderUtils.loadProperties(resource);
                Set<String> strings = properties.stringPropertyNames();
                strings.forEach((key)->listClassName.add(properties.getProperty(key)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("2121");
    }
}
