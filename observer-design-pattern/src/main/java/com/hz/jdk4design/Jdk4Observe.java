package com.hz.jdk4design;

import java.util.Observable;
import java.util.Observer;

/**
 * jdk本身自带的观察者   继承 java.util.Observe
 * @author hz
 * @create 2020-12-30
 */
public class Jdk4Observe implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("mmmmmm");
    }

}
