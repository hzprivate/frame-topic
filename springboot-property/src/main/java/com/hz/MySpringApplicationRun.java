package com.hz;

import com.hz.bean.HumanBean;
import com.hz.config.EnableHumanBeanProperties;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author hz
 * @Description:
 * @create 2021-01-12
 */
@SpringBootApplication
@EnableHumanBeanProperties(value = HumanBean.class)
public class MySpringApplicationRun {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MySpringApplicationRun.class);
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        HumanBean bean = beanFactory.getBean(HumanBean.class);
        System.out.println(bean.toString());

    }
}
