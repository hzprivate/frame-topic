package com.hz.beanPostProcessor;

import com.hz.config.RedisConf;
import com.hz.exception.RedisException;
import com.hz.redis.RedisClient;
import com.hz.registar.RedisConfRegistrar;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;

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
public class RedisConfPostProcessor implements ApplicationContextAware {
    @Autowired
    Environment env;
    private ApplicationContext context;

    //RedisConf 实例化前初始化参数
    @PostConstruct
    public void initHumanBeanEnv() {
        RedisConf bean = context.getBean(RedisConf.class);
        Properties p = new Properties();
        //填充env的 key/value 到 Properties中（对应RedisConf所有key）
        Arrays.stream(RedisConf.class.getDeclaredFields()).forEach(name -> {
            String key = name.getName();
            try {
                p.setProperty(key, env.getProperty(RedisConfRegistrar.prefix + key));
            } catch (Exception e) {
                throw new RedisException("redis配置文件 属性名称配置有误{" + RedisConfRegistrar.prefix + key + "}",e);
            }
        });
        //properties 转化为 RedisConf
        try {
            copyProperties(bean, p);
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
