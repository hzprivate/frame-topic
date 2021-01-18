package com.hz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author hz
 * @Description:
 * @create 2021-01-17
 */
@SpringBootApplication
public class SpringTxApplicationRun {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringTxApplicationRun.class);
        springApplication.setAdditionalProfiles("dataSourceCompany");
        springApplication.run(args);
    }
}
