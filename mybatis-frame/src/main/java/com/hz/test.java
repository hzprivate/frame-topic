package com.hz;

import com.hz.app.Appconfig;
import com.hz.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;


/**
 * @author hz
 * @create 2020-11-16
 */
public class test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        context.register(Appconfig.class);
        context.refresh();
        UserService userService = (UserService) context.getBean("userService");
        List<Map> list = userService.getList();
        List<Map> list1 = userService.getList();

        System.out.println("打印结果："+list);

    }


}
