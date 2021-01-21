package com.hz.registar;

import com.hz.beanPostProcessor.RedisConfPostProcessor;
import com.hz.config.RedisConf;
import com.hz.interf.EnableRedis;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;

/**
 * 注册 RedisConf 和 RedisConfPostProcessor 到spring容器中
 * @author hz
 * @create 2021-01-12
 */
public class RedisConfRegistrar implements ImportBeanDefinitionRegistrar {
    public static String prefix="";
    @Override
    public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
        //获取 注解 value()中的值
//        this.getTypes(metadata).forEach(myclass->{
//            GenericBeanDefinition bd = new GenericBeanDefinition();
//            ((GenericBeanDefinition) bd).setBeanClass(myclass);
//            registry.registerBeanDefinition(myclass.getSimpleName(),bd);
//        });

        prefix = getPrefix(metadata);

        GenericBeanDefinition bd = new GenericBeanDefinition();
        ((GenericBeanDefinition) bd).setBeanClass(RedisConf.class);
        registry.registerBeanDefinition(RedisConf.class.getSimpleName(),bd);

        GenericBeanDefinition p = new GenericBeanDefinition();
        ((GenericBeanDefinition) p).setBeanClass(RedisConfPostProcessor.class);
        registry.registerBeanDefinition(RedisConfPostProcessor.class.getSimpleName(),p);

    }


//    /**
//     * 获取 @EnableRedis 注解 value()中的值
//     * @param metadata
//     * @return
//     */
//    private Set<Class<?>> getTypes(AnnotationMetadata metadata) {
     //metadata.getAnnotations   ----需要springboot 2.3.7版本支持
//        return (Set)metadata.getAnnotations().stream(EnableRedis.class).flatMap((annotation) -> {
//            return Arrays.stream(annotation.getClassArray("value"));
//        }).filter((type) -> {
//            return Void.TYPE != type;
//        }).collect(Collectors.toSet());
//    }

    /**
     * 获取 @EnableRedis 注解 prefix()中的值
     * @param metadata
     * @return
     */
    private String getPrefix(AnnotationMetadata metadata) {
        //metadata.getAnnotationAttributes。springboot 2.0.3版本支持
        String prefix = metadata.getAnnotationAttributes(EnableRedis.class.getName()).get("prefix").toString();
        if(StringUtils.isEmpty(prefix)){
            return metadata.getAnnotationAttributes(EnableRedis.class.getName()).get("prefix").toString();
        }else{
            return metadata.getAnnotationAttributes(EnableRedis.class.getName()).get("prefix").toString()+".";
        }
    }


}
