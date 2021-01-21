package com.hz.singleTon;

/**
 *测试 五种单例模式
 * 懒汉模式  双重检查锁
 * @author hz
 * @create 2020-10-10
 */
public class SingleTonLazyDoubleCheck {
	private volatile static SingleTonLazyDoubleCheck singleTon =null;
	private SingleTonLazyDoubleCheck() {
	}
	public static  SingleTonLazyDoubleCheck getInstance(){
		if(singleTon == null){
			synchronized (SingleTonLazyDoubleCheck.class){
				if(singleTon == null){
					singleTon = new SingleTonLazyDoubleCheck();
				}
			}
		}
		return singleTon;
	}

}
