package com.craftsman.sample.foundation.task;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author chenfanglin
 * @desc 用于实现timer
 */
public class TimerTest{
    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        TimerTask timeTaskFirst=new TimerTask() {
            @Override
            public void run() {
                System.out.println("timeTaskFirst running ------"+(System.currentTimeMillis()-startTime));
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        TimerTask timeTaskSecond=new TimerTask() {
            @Override
            public void run() {
                System.out.println("timeTaskSecond running end .end time------"+(System.currentTimeMillis()-startTime));
            }
        };
        Timer timer=new Timer();
        timer.schedule(timeTaskFirst,1000);
        timer.schedule(timeTaskSecond,3000);
    }
}
