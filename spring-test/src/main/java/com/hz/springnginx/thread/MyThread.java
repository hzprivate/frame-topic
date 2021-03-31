package com.hz.springnginx.thread;

import com.hz.springnginx.task.TaskTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author hz
 * @create 2021-03-31
 */
public class MyThread implements Runnable {
    ThreadPoolTaskExecutor thread;
    private Object eleme;

    private ConcurrentLinkedDeque list;

    public MyThread(Object i, ThreadPoolTaskExecutor thread, ConcurrentLinkedDeque list) {
        this.eleme = i;
        this.thread = thread;
        this.list = list;
    }

    @Override
    public void run() {
        thread.execute(new Runnable() {
            @Override
            public void run() {
                list.remove(eleme);
                System.out.println("list删除后：" + list.size());
            }
        });
    }
}
