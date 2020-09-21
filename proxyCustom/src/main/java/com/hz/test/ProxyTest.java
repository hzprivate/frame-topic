package com.hz.test;

import com.hz.dao.UserDao;
import com.hz.dao.UserDaoImpl;
import com.hz.invocationHandler.MyProxyInvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author hz
 * @Description:
 * @create 2020-09-19
 */
public class ProxyTest {
    public static void main(String[] args) {

        UserDao o = (UserDao) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), new Class[]{UserDao.class}, new MyProxyInvocationHandler(new UserDaoImpl()));
        o.query();
    }
}
