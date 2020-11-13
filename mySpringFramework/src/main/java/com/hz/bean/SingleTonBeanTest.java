package com.hz.bean;

import com.hz.factory.MyApplicationAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;


/**
 * @author hz
 * @create 2020-10-12
 */
@Component
public class SingleTonBeanTest {

	@Autowired
    MyApplicationAware myApplicationAware;

	@Autowired
	private PrototypeBeanTest prototypeBeanTest;


	@Lookup
	public PrototypeBeanTest getPrototypeBeanTest() {
		return null;
	}

	public void test(){
		System.out.println("......SingleTonBeanTest");
	}


	//放弃一部分控制反转  通过调用方法去属性赋值注入
//	public void getObject(){
//		prototypeBeanTest = (PrototypeBeanTest) myApplicationAware.getContext().getBean("prototypeBeanTest");
//		System.out.println(prototypeBeanTest);
//	}

}
