package com.hz.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Map;

public interface UserDao {
    @Insert("insert into user(name,age) values('hh',26)")
    public void insertUser();

    @Update("update user set name='hj' where name='hh' ")
    public void updateUser();

    @Select("select * from user where uuid =44 ")
    public Map selectUser();

    @Select("select * from `user` where `name` =#{name} and password=#{password} and sex=#{sex}")
    public Map selectTestNull(Map map);
}
