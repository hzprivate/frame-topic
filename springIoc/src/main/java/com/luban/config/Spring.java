package com.luban.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 *
 * @author hz
 * @Description:
 * @create 2020-08-12
 */
@Configuration
@ComponentScan(basePackages = "com.luban",excludeFilters = {@Filter(type= FilterType.REGEX,pattern = "com.luban.service.*")})
//@ImportResource("classpath:spring.xml")
public class Spring {

}
