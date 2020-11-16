package com.hz.singleTon.bean;

/**
 * @author hz
 * @create 2020-10-10
 */
public class Teacher {
	private static Teacher teacher = new Teacher();

	private Teacher() {
	}

	public static Teacher createInstance(){
		return teacher;
	}
}
