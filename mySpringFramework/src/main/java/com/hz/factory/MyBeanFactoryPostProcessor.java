package com.hz.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * BeanFactoryPostProcessor 可以改变bean的定义 beanDefiniton
 * 此时的spring容器还没有开始实例化bean，
 * 因此自定义的BeanFactoryPostProcessor实现类不要做与bean实例有关的操作，
 * 而是做一些与bean定义有关的操作，例如修改某些字段的值，这样后面实例化的bean的就会有相应的改变；
 * @author hz
 * @create 2020-10-09
 */
//@Component
// equals context.addBeanFactoryPostProcessor(new MyBeanFactoryPostProcessor());
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("MyBeanFactoryPostProcessor start.....");
		//通过使用BeanFactory.getBean())，但是这样做会导致过早的bean实例化，违反标准的容器生命周期。
		// 这可能会导致负面的副作用，比如绕过bean的后处理。

		//如果希望更改实际bean实例(即从配置元数据创建的对象)，
		// 则需要使用BeanPostProcessor(在前面通过使用BeanPostProcessor自定义bean中进行了描述)。

		//更改beanDefinition中 name属性的默认值,scope为单例
		BeanDefinition book = beanFactory.getBeanDefinition("changeBeanDefinition");
		MutablePropertyValues pv = book.getPropertyValues();
		pv.addPropertyValue("name", "default color to yellow");
		book.setScope(BeanDefinition.SCOPE_SINGLETON);
	}
}
