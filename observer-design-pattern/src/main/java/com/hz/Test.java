package com.hz;

import com.hz.observice.impl.FatTigger;
import com.hz.observice.impl.FatTiggerGirlFriends;
import com.hz.subject.impl.CangTeacher;

/**
 * @author hz
 * @create 2020-12-30
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("苍老师发布新片");
        //发行一部苍老师影片
        CangTeacher cangTeacher = new CangTeacher();
        //胖虎同学试看五分钟后粉了
        FatTigger fatTigger = new FatTigger("胖虎",cangTeacher);
        //他女朋友也在旁观看。
        FatTiggerGirlFriends girlFriends = new FatTiggerGirlFriends("胖虎他女朋友",cangTeacher);
        //发现还可以
        //都准备先订阅
        System.out.println("胖虎和他女朋友发现后均订阅");
        fatTigger.order();
        girlFriends.order();

        //苍老师电影统一开始播放
        cangTeacher.play();

        //四秒后两人均发现 精彩剧情 做出相应行为
        fatTigger.action();
        girlFriends.action();

        System.out.println("苍老师又发布新片");
        cangTeacher.play();
        fatTigger.action();
    }
}
