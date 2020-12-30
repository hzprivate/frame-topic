package com.hz.springListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * @author hz
 * @create 2020-12-30
 */
public class SpringEmailEvent extends ApplicationContextEvent {
    public SpringEmailEvent(ApplicationContext source) {
        super(source);
    }
}
