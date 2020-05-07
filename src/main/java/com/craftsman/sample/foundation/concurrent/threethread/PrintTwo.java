package com.craftsman.sample.foundation.concurrent.threethread;

public class PrintTwo implements Runnable {

    @Override
    public void run() {
        while (ThreeThreadClient.LOCK_INT_COUNT==2){
            System.out.println("two");
            ThreeThreadClient.LOCK_INT_COUNT++;
        }
    }

}
