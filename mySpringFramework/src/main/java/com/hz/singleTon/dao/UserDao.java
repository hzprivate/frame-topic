package com.hz.singleTon.dao;

import org.springframework.stereotype.Component;

/**
 * @author hz
 * @create 2020-09-29
 */
@Component
public class UserDao {
	public void query(){
		System.out.println("userDao query.....");
	}
}
