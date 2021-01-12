package com.hz.config;

import com.hz.bean.HumanBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author hz
 * @Description:
 * @create 2021-01-12
 */
@Configuration
@PropertySource(value = "classpath:/test.properties",encoding = "UTF-8")
public class AppConfig {
    @Bean
    public TomcatServletWebServerFactory initTomcat(){
        TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory();
        tomcatServletWebServerFactory.setPort(8090);
        return  tomcatServletWebServerFactory;
    }
}
