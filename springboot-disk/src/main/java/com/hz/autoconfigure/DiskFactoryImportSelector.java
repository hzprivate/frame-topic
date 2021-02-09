package com.hz.autoconfigure;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.type.AnnotationMetadata;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author hz
 * @create 2021-02-05
 */
public class DiskFactoryImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        //内置
        String[] instanceNames = getInstanceNames();
        //调用方传来
        Set<String> annotationTypes = annotationMetadata.getAnnotationTypes();

        //简单逻辑判断 传来值是否为内置 以及需要实例化 后期可以根据@conditional判断
        String[] result =new String[]{};
        for(int i=0;i<instanceNames.length;i++){
            for (String annotationType : annotationTypes) {
                if(annotationType.equals(instanceNames)){
                    result[i]=annotationType;
                }
            }
        }

        return result;
    }

    private static String[] getInstanceNames() {
        // 获取ClassLoader
//        ClassLoader classLoader = SpringbootDiskApplication.class.getClassLoader();
        //获取线程类加载器
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        // Use names and ensure unique to protect against duplicates
        // 定义全路径List集合，即返回值 listClassName 是所有 classpath 下面的 META-INF/disk.factories 中定义的values
        List<String> listClassName = new ArrayList<>();
        String[] list = new String[]{};
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
            return listClassName.toArray(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String[0];
    }

//        /**
////     * 获取 @EnableRedis 注解 value()中的值
////     * @param metadata
////     * @return
////     */
////    private Set<Class<?>> getTypes(AnnotationMetadata metadata) {
////    metadata.getAnnotations   ----需要springboot 2.3.7版本支持
////        return (Set)metadata.getAnnotations().stream(EnableRedis.class).flatMap((annotation) -> {
////            return Arrays.stream(annotation.getClassArray("value"));
////        }).filter((type) -> {
////            return Void.TYPE != type;
////        }).collect(Collectors.toSet());
////    }
}
