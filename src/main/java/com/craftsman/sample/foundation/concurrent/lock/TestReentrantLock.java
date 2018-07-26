package com.craftsman.sample.foundation.concurrent.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenfanglin
 * @desc 测试使用ReentrantLock 使用condition进行现场之间的调度
 */
public class TestReentrantLock {
    public static void main(String[] args) {
        final Lock lock=new ReentrantLock();
        Condition condition=lock.newCondition();
        new Thread(()->{
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName()+"执行");
                System.out.println(Thread.currentThread().getName()+"进入等待");
                TimeUnit.SECONDS.sleep(3);
                condition.await();
                System.out.println(Thread.currentThread().getName()+"执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }).start();
       new Thread(()->{
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName()+"执行");
                TimeUnit.SECONDS.sleep(3);
                condition.signal();
                System.out.println(Thread.currentThread().getName()+"执行结束");
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }).start();


    }
}
