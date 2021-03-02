package com.hz.controller;

import com.hz.service.OrderService;
import com.hz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author hz
 * @Description:
 * @create 2021-01-17
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @RequestMapping("/insert")
    public Map insertUserInfo(){
        try {
            userService.insertAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        return userService.insertUserInfo();
        return null;
    }

}
