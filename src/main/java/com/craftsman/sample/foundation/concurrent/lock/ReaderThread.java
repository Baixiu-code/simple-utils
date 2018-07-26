package com.craftsman.sample.foundation.concurrent.lock;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author chenfanglin
 * @desc 从仓库读取
 */
public class ReaderThread extends Thread{

    private Depot depot;
    public ReaderThread(Depot depot){
        this.depot=depot;
    }
    @Override
    public void run(){
        Random random=new Random();
        depot.getProduct(random.nextInt(depot.size()));
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
