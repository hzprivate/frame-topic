package com.hz.config;

import com.hz.bean.HumanBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Properties;
import static org.apache.commons.beanutils.BeanUtils.copyProperties;

/**
 * //模拟 @ConfigurationProperties 注解功能
 * @author hz
 * @create 2021-01-13
 */
@Component
public class HumanBeanPostProcessor{
    @Autowired
    Environment env;
    @Autowired
    MyApplicationContextAware contextAware;
    //HumanBean 实例化前初始化参数
    @PostConstruct
    public void  initHumanBeanEnv(){
        String prefix="test.";
        HumanBean bean = contextAware.getApplicationContext().getBean(HumanBean.class);
        Properties p = new Properties();
        //填充env的 key/value 到 Properties中（对应HumanBean所有key）
        Arrays.stream(HumanBean.class.getDeclaredFields()).forEach(name->{
            String key = name.getName();
            p.setProperty(key,env.getProperty(prefix+key));
        });
        //properties 转化为 humanBean
        try {
            copyProperties(bean,p);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
