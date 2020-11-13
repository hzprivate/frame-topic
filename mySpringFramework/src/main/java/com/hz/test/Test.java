package com.hz.test;

import com.hz.app.Appconfig;
import com.hz.bean.SimpleMovieLister;
import com.hz.factory.MyBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author hz
 * @create 2020-09-29
 */
public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(Appconfig.class);
		context.addBeanFactoryPostProcessor(new MyBeanFactory());
		//equals  @ java config中 @ImportResource
//		new XmlBeanDefinitionReader(context).loadBeanDefinitions("spring.xml");
		context.refresh();
//		UserDao userDao = (UserDao) context.getBean("userDao");
//		QueryDao queryDao = (QueryDao) context.getBean("bbb");
		DefaultListableBeanFactory autowireCapableBeanFactory = (DefaultListableBeanFactory) context.getAutowireCapableBeanFactory();
//		userDao.query();
//		queryDao.query();
//		System.out.println(student);


//		QueryDao queryDao = (QueryDao) context.getBean("queryDao");
//		Student su = (Student) context.getBean("student");
//		SillyB sy = (SillyB) context.getBean("sillyB");
//		System.out.println(".....................");
//		SingleTonBeanTest ly = (SingleTonBeanTest) context.getBean("singleTonBeanTest");
//		SingleTonBeanTest ly1 = (SingleTonBeanTest) context.getBean("singleTonBeanTest");
//		System.out.println(ly.getPrototypeBeanTest());
//		System.out.println(ly1.getPrototypeBeanTest());
//		ly.getObject();
//		ly1.getObject();
		SimpleMovieLister requiredComTest = (SimpleMovieLister) context.getBean("simpleMovieLister");
		System.out.println(".....................");
	}
}
