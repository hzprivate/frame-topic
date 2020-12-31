package com.hz.observice.impl;

import com.hz.observice.Human;
import com.hz.subject.HMovie;

/**
 * @author hz
 * @create 2020-12-30
 */
public class FatTigger implements Human {
    private HMovie hMovie;
    private String name;

    public FatTigger(String name,HMovie hMovie) {
        this.hMovie = hMovie;
        this.name = name;
    }

    @Override
    public void play() {
        System.out.println(this.name+"开始播放影片");
    }

    @Override
    public void action() {
        System.out.println(this.name+"准备去厕所枪战了");
    }

    @Override
    public void order() {
        hMovie.addObserve(this);
    }

    @Override
    public void cancelOrder() {
        hMovie.removeObserve(this);
    }
}
