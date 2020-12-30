package com.hz.springListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * //事件源 发布事件
 * @author hz
 * @create 2020-12-30
 */
@Component
public class EmailBean {
    @Autowired
    ApplicationContext applicationContext;
    private String content;
    public void sendEmail(){
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
