package com.hz.singleTon;

/**
 * 测试 五种单例模式
 * 懒汉模式  非线程安全
 *
 * @author hz
 * @create 2020-10-10
 */
public class SingleTonLazy {
	private static SingleTonLazy singleTon = null;

	private SingleTonLazy() {
	}

	public static SingleTonLazy getInstance() {
		if (singleTon == null) {
			singleTon = new SingleTonLazy();
		}
		return singleTon;
	}

}
