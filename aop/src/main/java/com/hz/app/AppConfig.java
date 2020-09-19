package com.hz.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author hz
 * @Description:
 * @create 2020-09-07
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com")
public class AppConfig {
}
