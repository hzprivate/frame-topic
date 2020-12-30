package com.hz.springListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;

/**
 * @author hz
 * @create 2020-12-30
 */
public class SpringEmailListener implements ApplicationListener<SpringEmailEvent> {

    @Override
    public void onApplicationEvent(SpringEmailEvent springEmailEvent) {
        ApplicationContext source = (ApplicationContext) springEmailEvent.getSource();
//        source.publishEvent();
    }
}
