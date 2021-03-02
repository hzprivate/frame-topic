package com.hz;

import com.nbaisino.interf.EnableRedis;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author hz
 * @Description:
 * @create 2021-01-17
 */
@SpringBootApplication
//@EnableTrimStr
@EnableRedis
public class SpringTxApplicationRun {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringTxApplicationRun.class);
        springApplication.setAdditionalProfiles("dataSourceCompany");
        springApplication.run(args);
    }
}
