package com.hz.web;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hz
 * @create 2020-12-28
 */
@Controller
public class GreetController {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    //发布给订阅了 /topic/greetings主题的用户
    public Map<String, String> greeting(String message) throws Exception {
        System.out.println(message);
        Map<String, String> map = new HashMap();
        map.put("data", "hello " + message + "!");
        return map;
    }

}
