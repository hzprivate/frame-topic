package com.hz.controller;

import com.alibaba.fastjson.JSON;
//import com.hz.bean.OrderDTO;
import com.hz.service.OrderService;
//import com.hz.annotation.TrimStr;
//import com.hz.annotation.TrimValidate;
import com.hz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hz
 * @Description:
 * @create 2021-01-17
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @RequestMapping("/update")
//    @TrimStr
    public String updateOrder(){
         orderService.updateOrder();

//        String s = JSON.toJSONString(orderDTO);
        return null;
    }



}
