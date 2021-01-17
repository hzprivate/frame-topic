package com.hz.dao;

import org.apache.ibatis.annotations.Insert;

public interface OrderDao {
   @Insert("insert into `order`(name,num) values('hz',26)")
    public void insertOrder();
}