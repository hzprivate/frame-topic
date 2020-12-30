package com.hz.springListener;

import com.hz.config.Appconfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author hz
 * @create 2020-12-30
 */
public class ApplicationStart {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class);
       context.getBean(EmailBean.class).sendEmail();

    }
}
