package com.hz.subject.impl;

import com.hz.observice.Human;
import com.hz.subject.HMovie;

import java.util.concurrent.Callable;

/**
 * @author hz
 * @create 2020-12-30
 */
public class CangTeacher implements HMovie {

    @Override
    public void addObserve(Human human) {
        humanList.add(human);
    }

    @Override
    public void removeObserve(Human human) {
        humanList.remove(human);
    }

    @Override
    public void play() {
        System.out.println("通知所有订阅者，苍老师电影统一开始播放，");
        //并发通知所有订阅得观察者 准备开始播放

        new Runnable() {
            @Override
            public void run() {
                humanList.forEach(human -> human.play());
            }
        }.run();


    }
}
