package com.hz.observice;

/**
 * @author hz
 * @create 2020-12-30
 */
public interface Human {
    /**
     * 播放影片
     */
    void play();
    /**
     * 订阅
     */
    void order();

    /**
     * 取消订阅
     */
    void cancelOrder();
    /**
     * 看完精彩剧情行为
     */
    void action();
}
