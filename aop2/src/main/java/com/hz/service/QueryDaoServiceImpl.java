package com.hz.service;

import com.hz.dao.QueryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 获得的 QueryDao对象有多个实现类，如何在程序中可以调用想要的QueryDaoImpl
 * 因为据我们所知，spring容器完成的bean初始化后，其属性已经被确定某个具体对象，
 * 那后期的程序中，如何自由获得想要的实现类，实现不同功能
 * @author hz
 * @Description:
 * @create 2020-11-20
 */
@Service
public class QueryDaoServiceImpl {
    @Autowired
//    private QueryDao queryDao;//QueryDao1Impl ,QueryDao2Impl ? 会报错，有两个bean 无法注入

    //优化
    //此处map中会含有所有的QueryDao实现类
    private Map<String,QueryDao> queryDaoMap;
    public  void query(){
        queryDaoMap.entrySet().forEach(map->map.getValue().getData());
    }
}
