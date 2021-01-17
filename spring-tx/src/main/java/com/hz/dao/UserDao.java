package com.hz.dao;

import org.apache.ibatis.annotations.Insert;

public interface UserDao {
    @Insert("insert into user(name,age) values('hz',26)")
    public void insertUser();
}
