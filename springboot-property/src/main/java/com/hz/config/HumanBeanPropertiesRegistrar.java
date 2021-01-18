package com.hz.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author hz
 * @Description:
 * @create 2021-01-12
 */
public class HumanBeanPropertiesRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
        this.getTypes(metadata).forEach(myclass->{
            GenericBeanDefinition bd = new GenericBeanDefinition();
            ((GenericBeanDefinition) bd).setBeanClass(myclass);
            registry.registerBeanDefinition(myclass.getSimpleName(),bd);
        });
    }
    private Set<Class<?>> getTypes(AnnotationMetadata metadata) {
        return (Set)metadata.getAnnotations().stream(EnableHumanBeanProperties.class).flatMap((annotation) -> {
            return Arrays.stream(annotation.getClassArray("value"));
        }).filter((type) -> {
            return Void.TYPE != type;
        }).collect(Collectors.toSet());
    }

}
