package com.hz.singleTon;

/**
 * 单例模式  Holder模式 内部类
 * @author hz
 * @create 2020-10-10
 */
public class SingleTonInner {

	private static class SingletonHolder{
		private static SingletonHolder instance = new SingletonHolder();
	}

	private SingleTonInner() {
	}

	public static  SingletonHolder getInstance(){
		return SingletonHolder.instance;
	}
}
