package com.hz.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author hz
 * @Description:
 * @create 2020-12-24
 */
@Configuration
@ComponentScan("com.hz")
public class AppConfig {

//    /**
//     * 视图解析器
//     * @return
//     */
//    @Bean
//    public InternalResourceViewResolver internalResourceViewResolver(){
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver("/",".jsp");
//        return resolver;
//    }

}
