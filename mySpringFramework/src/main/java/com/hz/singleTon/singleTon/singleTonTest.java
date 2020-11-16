package com.hz.singleTon.singleTon;

/**
 * @author hz
 * @create 2020-10-10
 */
public class singleTonTest {
	public static void main(String[] args) {
		System.out.println(SingleTonLazy.getInstance());
		System.out.println(SingleTonHunger.getInstance());
		System.out.println(SingleTonLazyThreadSafe.getInstance());
		System.out.println(SingleTonInner.getInstance());
		System.out.println(SingleTonInner.getInstance());
	}
}
