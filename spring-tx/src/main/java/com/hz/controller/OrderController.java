package com.hz.controller;

import com.hz.bean.OrderDTO;
import com.hz.config.DTOTrim;
import com.hz.config.ObjectTrim;
import com.hz.service.OrderService;
import com.hz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.util.Map;

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
    public String insertOrder(@ObjectTrim OrderDTO orderDTO, HttpServletRequest request){
         orderService.insertOrder();
         return "0000";
    }

}
