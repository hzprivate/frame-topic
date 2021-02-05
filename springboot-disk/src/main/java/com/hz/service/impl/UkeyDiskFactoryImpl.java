package com.hz.service.impl;

import com.hz.service.DiskFactory;

/**
 * @author hz
 * @create 2021-02-03
 */
public class UkeyDiskFactoryImpl implements DiskFactory {
    @Override
    public void sp() {
        System.out.println("ukey 上盘");
    }

    @Override
    public void xp() {
        System.out.println("ukey 下盘");
    }
}
