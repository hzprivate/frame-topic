package com.luban.service;


import com.luban.dao.IndexDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hz
 * @Description:
 * @create 2020-08-10
 */
@Service
public class IndexService{
    @Autowired
    private IndexDao indexDao;

    public IndexService() {
        System.out.println("indexService");
    }

    public void serviceTest() {
        indexDao.testDao();
    }


//    注入的两种方式：1.构造器注入  2.set方法注入
    public void setIndexDao(IndexDao indexDao) {
        this.indexDao = indexDao;
    }
}
