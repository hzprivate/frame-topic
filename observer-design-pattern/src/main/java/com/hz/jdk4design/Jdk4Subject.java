package com.hz.jdk4design;

import java.util.Observable;

/**
 * jdk自带 被观察者 继承 java.util.Observable
 * @author hz
 * @create 2020-12-30
 */
public class Jdk4Subject extends Observable {

    public static void main(String[] args) {
        //将观察者添加到集合中
        Jdk4Subject jdk4Subject = new Jdk4Subject();
        jdk4Subject.addObserver(new Jdk4Observe());
        //状态已改变
        jdk4Subject.setChanged();
        //通知所有观察者
        jdk4Subject.notifyObservers();
    }
}
