package com.hz.invocationHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author hz
 * @Description:
 * @create 2020-09-19
 */
public class MyProxyInvocationHandler implements InvocationHandler {
    private Object target;

    public MyProxyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk动态代理 增强后代理对象业务>>>");
        return method.invoke(target,args);
    }
}
