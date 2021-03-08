package com.hz;

import com.hz.dao.UserDao;
import com.nbaisino.interf.EnableRedis;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hz
 * @Description:
 * @create 2021-01-17
 */
@SpringBootApplication
//@EnableTrimStr
@EnableRedis
@EnableScheduling   //启用任务模式
public class SpringTxApplicationRun {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringTxApplicationRun.class);
        springApplication.setAdditionalProfiles("dataSourceCompany");
        springApplication.run(args);
    }
}
