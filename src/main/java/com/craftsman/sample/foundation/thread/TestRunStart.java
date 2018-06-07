package com.craftsman.sample.foundation.thread;

/**
 * @Author chenfanglin 【chenfanglincfl@163.com】
 * @Date 2017/5/316:36
 */
public class TestRunStart extends   Thread{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        TestRunStart testRunStartThread=new TestRunStart();
        Thread thread=new Thread(testRunStartThread,"a");
        thread.run();
        System.out.println("--------------------------------------");
        thread.start();
    }
}
