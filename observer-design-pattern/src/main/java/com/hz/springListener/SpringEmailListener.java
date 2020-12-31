package com.hz.springListener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author hz
 * @create 2020-12-30
 */
@Component
public class SpringEmailListener implements ApplicationListener<SpringEmailEvent> {

    @Override
    public void onApplicationEvent(SpringEmailEvent springEmailEvent) {
        System.out.println("监听到email事件启动");
    }
}
