package com.craftsman.sample.foundation.thread;

import lombok.Data;

/**
 * @Author chenfanglin 【chenfanglincfl@163.com】
 * @Date 2017/5/317:07
 */
@Data
public class TestSuspendResume extends Thread {

    private long i=0;


    @Override
    public void run() {
        while (1>0){
            i++;
        }
    }

    public static void main(String[] args) throws Exception{
        TestSuspendResume testSuspendResume=new TestSuspendResume();
        Thread thread=new Thread(testSuspendResume,"a");
        thread.start();
        Thread.sleep(1000);
        //暂停，测试i++停止，i的值不变
        thread.suspend();
        System.out.println("a="+System.currentTimeMillis()+" i="+testSuspendResume.getI());
        Thread.sleep(1000);
        System.out.println("a="+System.currentTimeMillis()+" i="+testSuspendResume.getI());
        //恢复，i++，i的值继续增加
        thread.resume();
        Thread.sleep(1000);
        System.out.println("a="+System.currentTimeMillis()+" i="+testSuspendResume.getI());
    }
}
