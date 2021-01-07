package com.hz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hz
 * @Description:
 * @create 2020-12-24
 */
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index(){
        return null;
    }
}
