package com.craftsman.sample.foundation.concurrent;

import java.util.concurrent.*;

/**
 * @Author chenfanglin 【chenfanglincfl@163.com】
 * @Date 2017/5/1015:15
 */
public class TestCountdownLatch {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(3);
        ExecutorService executorService=Executors.newFixedThreadPool(3);
        executorService.submit(new Thread(new Runner(cyclicBarrier,"1号选手")));
        executorService.submit(new Thread(new Runner(cyclicBarrier,"2号选手")));
        executorService.submit(new Thread(new Runner(cyclicBarrier,"3号选手")));
        executorService.shutdown();
    }
    private static class Runner implements  Runnable{
        private CyclicBarrier cyclicBarrier;
        private String name;
        private Runner(CyclicBarrier cyclicBarrier,String name){
            this.cyclicBarrier=cyclicBarrier;
            this.name=name;
        }
        @Override
        public void run() {
            try {
                cyclicBarrier.await();
                System.out.println(name+"准备");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(name+"起跑");
        }
    }
}
