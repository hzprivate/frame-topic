package com.hz.test;

import com.hz.cglib.MyMethodInterpect;
import com.hz.dao.IndexDao;
import org.springframework.cglib.core.SpringNamingPolicy;
import org.springframework.cglib.proxy.Enhancer;

/**
 * cglib代理 测试
 * @author hz
 * @Description:
 * @create 2020-11-07
 */
public class CglibTest {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(IndexDao.class);
        enhancer.setNamingPolicy(SpringNamingPolicy.INSTANCE);
        enhancer.setCallback(new MyMethodInterpect());
        IndexDao indexDao = (IndexDao) enhancer.create();
        indexDao.query();
    }
}
