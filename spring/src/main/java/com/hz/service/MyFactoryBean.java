package com.hz.service;

import com.hz.entity.User;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * 实现自己的FactoryBean
 * @author hz
 * @create 2020-09-23
 */
@Component("myFactoryBean")
public class MyFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
