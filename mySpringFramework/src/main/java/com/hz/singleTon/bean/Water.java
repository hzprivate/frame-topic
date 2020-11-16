package com.hz.singleTon.bean;

/**
 * @author hz
 * @create 2020-10-10
 */
public class Water {
	private static Book book = new Book();
	public Book getInstanceBook(){
		return book;
	}

}
