package com.hz.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 对代理方法进行拦截
 * @author hz
 * @Description:
 * @create 2020-11-07
 */
@Component
public class MyMethodInterpect implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib拦截");
        return methodProxy.invokeSuper(o,objects);
    }
}
