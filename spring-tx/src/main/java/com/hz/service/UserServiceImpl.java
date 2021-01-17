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
    @Transactional(propagation= Propagation.REQUIRES_NEW)
    public Map insertUserInfo() {
        //执行正常
        userdao.insertUser();

        //事务异常
        try {
            orderService.insertOrder();
        } catch (Exception e) {
            logger.error("sql异常",e);
        }

        Map map = new HashMap();
        map.put("code","9999");
        map.put("msg","操作失败");
        return  map;
    }
}
