package com.hz.app;

import com.hz.annotiton.AutoSetValueOnRefresh;
import com.hz.annotiton.EnableHzConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author hz
 * @Description:
 * @create 2020-11-20
 */
@Configuration
@ComponentScan("com.hz")
//在注解上定义属性，容器初始化时赋值给某个对象
@AutoSetValueOnRefresh(ip="192.168.20.185",address = "浙江宁波")
//实现通过注解开启HzConfig类的bean
@EnableHzConfig
public class AppConfig {

}
