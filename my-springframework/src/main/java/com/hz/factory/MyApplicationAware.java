package com.hz.factory;

import com.hz.bean.PrototypeBeanTest;
import com.hz.bean.SingleTonBeanTest;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author hz
 * @create 2020-10-12
 */
@Component
public class MyApplicationAware implements ApplicationContextAware {
	private   ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
//		SingleTonBeanTest singleTonBeanTest = (SingleTonBeanTest) applicationContext.getBean("singleTonBeanTest");
//		PrototypeBeanTest prototypeBeanTest = (PrototypeBeanTest) applicationContext.getBean("prototypeBeanTest");
//
//		singleTonBeanTest.setPrototypeBeanTest(prototypeBeanTest);
		this.applicationContext= context;
	}

	public  ApplicationContext getContext(){
		return this.applicationContext;
	}


}
