package com.hz.service;

import com.hz.dao.UserDao;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author hz
 * @Description:
 * @create 2021-01-18
 */
@Service
public class UserServiceImpl implements UserService {
    org.slf4j.Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    OrderService orderService;
    @Autowired
    UserDao userdao;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map insertUserInfo(){
        userdao.insertUser();
//        int i =1/0;
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map insertAll(){
        insertUserInfo();
        orderService.selectUser();

        return null;
    }
}
