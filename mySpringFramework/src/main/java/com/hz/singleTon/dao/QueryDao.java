package com.hz.singleTon.dao;

import com.hz.singleTon.bean.Teacher;

/**
 * @author hz
 * @create 2020-10-09
 */
public class QueryDao {
	private Teacher teacher;
	private int a;
	public void query(){
		System.out.println("queryDao query.....");
	}

//	public QueryDao(Teacher teacher,int a) {
//		this.teacher = teacher;
//		this.a = a;
//	}
}
