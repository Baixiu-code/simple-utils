package com.craftsman.sample.foundation.task;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author chenfanglin
 * @desc scheduledThreadPool 改良Timer
 */
public class ScheduledThreadPoolTest {
    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        ScheduledExecutorService scheduledExecutorService=Executors.newScheduledThreadPool(2);
        TimerTask timerTaskFirst=new TimerTask() {
            @Override
            public void run() {
                System.out.println("time task first start time"+(System.currentTimeMillis()-startTime));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        TimerTask timerTaskSecond=new TimerTask() {
            @Override
            public void run() {
                System.out.println("time task second start time"+(System.currentTimeMillis()-startTime));
            }
        };
        scheduledExecutorService.schedule(timerTaskFirst,1,TimeUnit.SECONDS);
        scheduledExecutorService.schedule(timerTaskSecond,3,TimeUnit.SECONDS);
    }
}
