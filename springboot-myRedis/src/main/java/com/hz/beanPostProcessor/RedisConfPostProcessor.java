package com.hz.beanPostProcessor;

import com.hz.config.RedisConf;
import com.hz.interf.EnableRedis;
import com.hz.redis.RedisClient;
import com.hz.registar.RedisConfRegistrar;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Properties;

import static org.apache.commons.beanutils.BeanUtils.copyProperties;

/**
 * @author hz
 * @create 2021-01-13
 */
//模拟 @ConfigurationProperties 注解功能
public class RedisConfPostProcessor implements ApplicationContextAware{
    @Autowired
    Environment env;
    private ApplicationContext context;
    //RedisConf 实例化前初始化参数
    @PostConstruct
    public void  initHumanBeanEnv(){
        RedisConf bean = context.getBean(RedisConf.class);
        Properties p = new Properties();
        //填充env的 key/value 到 Properties中（对应RedisConf所有key）
        Arrays.stream(RedisConf.class.getDeclaredFields()).forEach(name->{
            String key = name.getName();
            p.setProperty(key,env.getProperty(RedisConfRegistrar.prefix+key));
        });
        //properties 转化为 RedisConf
        try {
            copyProperties(bean,p);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        RedisClient.redisconf = bean;

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
