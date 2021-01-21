package com.hz.factory;

import com.hz.bean.Book;
import com.hz.bean.RegistBeanDefinition;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author hz
 * @create 2020-11-09
 */
@Component
//此处加了注解以后，spring认为他是spring自定义的 BeanFactoryPostProcessor
//要在程序外部。通过 ApplicationContext.addBeanFactoryPostProcessor()添加
//源码中会有体现
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println("通过代码人为注册RegistBeanDefinition bd到spring容器中");
		RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RegistBeanDefinition.class);
		registry.registerBeanDefinition("registBeanDefinition",rootBeanDefinition);
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("MyBeanDefinitionRegistryPostProcessor  改变bean定义.....");
	}
}
