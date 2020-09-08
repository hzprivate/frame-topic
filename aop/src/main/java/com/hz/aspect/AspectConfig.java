package com.hz.aspect;

import com.hz.dao.OrderDao;
import com.hz.dao.OrderDaoImpl;
import com.hz.dao.TestDao;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author hz
 * @Description:
 * @create 2020-09-07
 */
@Component
@Aspect
public class AspectConfig {

    @DeclareParents(value = "com.hz.dao.*",defaultImpl = OrderDaoImpl.class)
    public static OrderDao orderDao;

    @Pointcut("execution(* com.hz.dao.*.*(..))")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void before(){
        System.out.println("执行前。。。。");
    }
}
