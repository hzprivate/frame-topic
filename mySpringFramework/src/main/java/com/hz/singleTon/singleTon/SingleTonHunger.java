package com.hz.singleTon.singleTon;

/**
 *测试 五种单例模式
 * 饿汉模式  非线程安全
 * @author hz
 * @create 2020-10-10
 */
public class SingleTonHunger {
	private static SingleTonHunger singleTon = new SingleTonHunger();

	private SingleTonHunger() {
	}
	public static SingleTonHunger getInstance(){
		return singleTon;
	}

}
