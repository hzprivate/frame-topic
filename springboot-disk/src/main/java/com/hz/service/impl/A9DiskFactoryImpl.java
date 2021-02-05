package com.hz.service.impl;

import com.hz.service.DiskFactory;

/**
 * @author hz
 * @create 2021-02-03
 */
public class A9DiskFactoryImpl implements DiskFactory {
    @Override
    public void sp() {
        System.out.println("A9 上盘");
    }

    @Override
    public void xp() {
        System.out.println("A9 下盘");
    }
}
