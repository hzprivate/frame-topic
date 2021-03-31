package com.hz.springnginx.task;

import com.hz.springnginx.thread.MyThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author hz
 * @create 2021-03-26
 */
@Component
public class TaskTest {
    @Autowired
    ThreadPoolTaskExecutor thread;
    @Scheduled(fixedRate = 5000)   //代表5秒钟执行一次 //@Scheduled(cron = "*/5 * * * * *")老的配置方式
    public void run(){
        //模拟从redis拿到数据
        List list = new ArrayList();
        for(int i=0;i<new Random().nextInt(8)+1;i++){
            list.add(i);
        }
        ConcurrentLinkedDeque result = new ConcurrentLinkedDeque(list);

        System.out.println("list初始化数量："+list.size());
        //并发执行 查询api结果
        for(int i=0;i<list.size();i++){
            thread.execute(new MyThread(result.toArray()[i],thread,result));
        }
    }
}
