package com.hz.singleTon.bean;

import com.hz.singleTon.factory.MyApplicationAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 实现BeanPostProcessor接口 会对实例化对象前后分别调用方法
 *  @PostConstruct  @PreDestroy 注解 。初始化前和销毁前调用方法  在服务器加载/卸载Servlet的时候运行，并且只会被服务器调用一次
 *  spring中Constructor、@Autowired、@PostConstruct的顺序： Constructor >> @Autowired >> @PostConstruct
 *  @Autowired, @Inject, @Value 不能在BeanPostProcessor 和BeanFactoryPostProcessor 中使用这些注解。该注解都是在后置处理中实现
 * @author hz
 * @create 2020-10-13
 */
@Component
public class MyBeanPostProcessor implements  BeanPostProcessor{
	@Autowired
	MyApplicationAware myApplicationAware;
	@PostConstruct
	public void preIntialize(){
		System.out.println("MyBeanPostProcessor .... start");
		System.out.println("实例化所有对象前，该步骤已经将bd对象存放到beanFactory工厂，BeanFactoryPostProcessor 先BeanPostProcessor执行");
		SingleTonBeanTest singleTonBeanTest = (SingleTonBeanTest) myApplicationAware.getContext().getBean("singleTonBeanTest");
		singleTonBeanTest.test();
	}
	@PreDestroy
	public void preDestory(){
		System.out.println("销毁前");
	}

	// simply return the instantiated bean as-is
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) {
//		System.out.println("每个对象初始化前");
//		System.out.println("Bean '" + beanName + "' created : " + bean.toString());
		return bean; // we could potentially return any object reference here...
	}
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) {
//		System.out.println("每个对象初始化后");
//		System.out.println("Bean '" + beanName + "' created : " + bean.toString());
		return bean;
	}




}
