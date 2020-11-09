package com.hz.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author hz
 * @create 2020-10-14
 */
@Component
public class SimpleMovieLister {
	private SingleTonBeanTest book;

	//自动构造注入
//	public SimpleMovieLister(SingleTonBeanTest book) {
//		this.book = book;
//	}

	//加 @Autowired set注入
	@Autowired
	public void setBook(SingleTonBeanTest book) {
		this.book = book;
	}
}
