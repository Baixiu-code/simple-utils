package com.craftsman.sample.foundation.thread;

import lombok.Data;

/**
 * @Author chenfanglin 【chenfanglincfl@163.com】
 * @Date 2017/5/319:39
 */
@Data
public class TestThreadPriority extends  Thread {
    private  volatile  int aCount=0;
    private  volatile  int bCount=0;
    private  volatile  int cCount=0;
    @Override
    public void run() {
        while(true){
                String name=Thread.currentThread().getName();System.out.println(name+"excute");
                switch (name){
                    case "a":
                        aCount++;
                        break;
                    case "b":
                        bCount++;
                        break;
                    case "c":
                        cCount++;
                        break;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        TestThreadPriority testThreadPriority=new TestThreadPriority();
        Thread threada=new Thread(testThreadPriority,"a");
        Thread threadb=new Thread(testThreadPriority,"b");
        Thread threadc=new Thread(testThreadPriority,"c");
        threada.setPriority(1);
        threadb.setPriority(2);
        threadc.setPriority(3);
        threada.start();
        threadb.start();
        threadc.start();
        Thread.sleep(10000);
        threada.stop();
        threadb.stop();
        threadc.stop();
        System.out.println("aCount="+testThreadPriority.getACount());
        System.out.println("bCount="+testThreadPriority.getBCount());
        System.out.println("cCount="+testThreadPriority.getCCount());
    }
}
