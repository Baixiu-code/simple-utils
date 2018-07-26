package com.craftsman.sample.foundation.concurrent.lock;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author chenfanglin
 * @desc ReentrantReadWrite 测试
 */
public class TestReentrantReadWriteLock {

    public static void main(String[] args) {
        List<String> initData= Lists.newArrayList("12","4","21");
        Depot depot=new Depot(initData);
        for (int i = 0; i < initData.size(); i++) {
            new ReaderThread(depot).start();
        }
        for (int i = 0; i < initData.size(); i++) {
            new WriterThread(depot).start();
        }
    }


}
