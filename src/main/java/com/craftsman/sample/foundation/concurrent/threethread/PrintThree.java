package com.craftsman.sample.foundation.concurrent.threethread;

public class PrintThree implements Runnable {
    @Override
    public void run() {
        while (ThreeThreadClient.LOCK_INT_COUNT==3){
            System.out.println("three");
            ThreeThreadClient.LOCK_INT_COUNT++;
        }

    }
}
