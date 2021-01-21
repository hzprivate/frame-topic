package com.luban.service;


import com.luban.dao.IndexDao;
import com.luban.dao.IndexDao1Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hz
 * @Description:
 * @create 2020-08-10
 */
@Service
public  class IndexService{

    @Autowired
    private IndexDao indexDao;

    @Lookup
    public IndexDao getIndexDao() {
        return null ;
    }



    public  void serviceHashCode(){
        System.out.println("service"+this.hashCode());
        System.out.println("dao"+getIndexDao().hashCode());

        System.out.println("service"+this.hashCode());
        System.out.println("dao"+getIndexDao().hashCode());

        System.out.println("service"+this.hashCode());
        System.out.println("dao"+getIndexDao().hashCode());
    }



//    注入的两种方式：1.构造器注入  2.set方法注入
//    public void setIndexDao(IndexDao indexDao) {
//        this.indexDao21Impl = indexDao;
//    }
}
