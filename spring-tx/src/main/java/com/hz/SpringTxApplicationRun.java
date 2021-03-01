package com.hz;

import com.hz.interf.EnableTrimStr;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author hz
 * @Description:
 * @create 2021-01-17
 */
@SpringBootApplication
//@EnableAspectJAutoProxy
@EnableTrimStr
public class SpringTxApplicationRun {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringTxApplicationRun.class);
        springApplication.setAdditionalProfiles("dataSourceCompany");
        springApplication.run(args);
    }
}
