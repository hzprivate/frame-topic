package com.hz.service;

import com.hz.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author hz
 * @create 2020-11-16
 */
@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public List<Map> getList(){
        return  userDao.getList();
    }
}
