package com.hz.singleTon.singleTon;

/**
 *测试 五种单例模式
 * 懒汉模式  线程安全
 * @author hz
 * @create 2020-10-10
 */
public class SingleTonLazyThreadSafe {
	private static SingleTonLazyThreadSafe singleTon =null;

	private SingleTonLazyThreadSafe() {
	}
	public static synchronized SingleTonLazyThreadSafe getInstance(){
		if(singleTon == null){
			singleTon = new SingleTonLazyThreadSafe();
		}
		return singleTon;
	}

}
