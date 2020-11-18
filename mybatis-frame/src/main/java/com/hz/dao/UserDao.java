package com.hz.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author hz
 * @create 2020-11-16
 */
public interface UserDao {

    @Select("select * from city")
    List<Map> getList();
}
