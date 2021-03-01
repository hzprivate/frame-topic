package com.hz.controller;

import com.alibaba.fastjson.JSON;
import com.hz.bean.OrderDTO;
import com.hz.service.OrderService;
import com.hz.aop.TrimStr;
import com.hz.aop.TrimValidate;
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
    @RequestMapping("/insertOrder")
    @TrimStr
    public String insertOrder(@TrimValidate OrderDTO orderDTO){
//         orderService.insertOrder();

        String s = JSON.toJSONString(orderDTO);
        return s;
    }

}
