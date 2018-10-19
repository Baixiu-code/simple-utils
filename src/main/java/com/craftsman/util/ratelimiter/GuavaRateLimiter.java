package com.craftsman.util.ratelimiter;

import com.google.common.util.concurrent.RateLimiter;
import java.util.concurrent.CountDownLatch;

/**
 * @author chenfanglin
 * @desc 使用RateLimiter 来实现流量限制
 */
public class GuavaRateLimiter {
    public static void main(String[] args) throws InterruptedException {
        //每秒限制10个请求
        RateLimiter rateLimiter=RateLimiter.create(10);
        int max=100;
        //构造CountDownLatch
        CountDownLatch countDownLatch=new CountDownLatch(max);
        long startTime=System.currentTimeMillis();
        for (int i = 0; i < max; i++) {
            Thread thread=new Thread(()->{
                //获取令牌
               rateLimiter.acquire();
                System.out.println(Thread.currentThread().getName());
                //计数减一
                countDownLatch.countDown();
            });
            thread.setName("第"+i+"ThreadName");
            //线程开始启动
            thread.start();
        }
        //当计数为0之前，当前线程都会阻塞
        countDownLatch.await();
        System.out.println("耗时:"+(System.currentTimeMillis()-startTime));
    }
}
