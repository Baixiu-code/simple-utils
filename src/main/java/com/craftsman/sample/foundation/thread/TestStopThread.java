package com.craftsman.sample.foundation.thread;

/**
 * @Author chenfanglin 【chenfanglincfl@163.com】
 * @Date 2017/5/318:02
 */
public class TestStopThread extends  Thread{
    private int i=0;
    @Override
    public void run() {
        try {
            while (true){
                System.out.println("i="+i++);
                if(this.interrupted()){
                        throw new InterruptedException();
                    }
                }
        } catch (InterruptedException e) {
            System.out.println("当前线程已经退出！");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        TestStopThread testStopThread=new TestStopThread();
        Thread thread=new Thread(testStopThread,"a");
        thread.start();
        Thread.sleep(50);
        thread.interrupt();
    }
}
