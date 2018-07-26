package com.craftsman.sample.foundation.concurrent.lock;


import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author chenfanglin
 * @desc  writer thread
 */
public class WriterThread extends Thread {

    private Depot depot;

    public WriterThread(Depot depot){
        this.depot=depot;
    }
    @Override
    public void run(){
        Random random=new Random();
        String str=String.valueOf(random.nextInt(100));
        depot.addProduct(str);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
