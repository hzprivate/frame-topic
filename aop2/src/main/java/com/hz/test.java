package com.hz;

import com.hz.app.AppConfig;
import com.hz.app.HzConfig;
import com.hz.aware.MyPc;
import com.hz.service.QueryDaoServiceImpl;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author hz
 * @Description:
 * @create 2020-11-20
 */
public class test {
    @Test
    public  void test1() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        MyPc myPc = context.getBean(MyPc.class);
        HzConfig bean = context.getBean(HzConfig.class);
        System.out.println(bean);
        System.out.println(myPc);
    }

    @Test
    public  void test2() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        QueryDaoServiceImpl bean = context.getBean(QueryDaoServiceImpl.class);
        bean.query();
    }
}
