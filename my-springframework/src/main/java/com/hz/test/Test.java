package com.hz.test;

import com.hz.app.Appconfig;
import com.hz.bean.Book;
import com.hz.bean.ChangeBeanDefinition;
import com.hz.bean.RegistBeanDefinition;
import com.hz.bean.SimpleMovieLister;
import com.hz.factory.MyBeanFactoryPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

/**
 * @author hz
 * @create 2020-09-29
 */
public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(Appconfig.class);
		context.addBeanFactoryPostProcessor(new MyBeanFactoryPostProcessor());
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

//		SimpleMovieLister requiredComTest = (SimpleMovieLister) context.getBean("simpleMovieLister");
		System.out.println(".....................");
		ChangeBeanDefinition cbd = (ChangeBeanDefinition) context.getBean("changeBeanDefinition");
		System.out.println(cbd.getName());
		RegistBeanDefinition registBeanDefinition = (RegistBeanDefinition) context.getBean("registBeanDefinition");
		System.out.println(Optional.of(registBeanDefinition));

	}
}
