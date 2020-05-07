package com.craftsman.sample.foundation.concurrent.threethread;


public class PrintFirst implements Runnable {
    @Override
    public void run() {
        System.out.println("first");
        ThreeThreadClient.LOCK_INT_COUNT++;
    }
}
