package com.craftsman.sample.foundation.concurrent.lock;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author chenfanglin
 * @desc 用于测试ReentrantReadWriteLock
 */
public class Depot {
    public  Depot(List<String> init){
        capacity.addAll(init);
    }
    private List<String> capacity=Lists.newArrayList();
    private ReadWriteLock readWriteLock=new ReentrantReadWriteLock();

    public String getProduct(int index){
        Lock readLock=readWriteLock.readLock();
        System.out.println(Thread.currentThread().getName()+"开始读取仓库内的商品"+index);
        readLock.lock();
        try {
            return  capacity.get(index);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            readLock.unlock();
            System.out.println(Thread.currentThread().getName()+"结束读取仓库内的商品"+index);
        }
    }

    public void addProduct(String product){
        System.out.println(Thread.currentThread().getName()+"开始添加仓库内的商品"+product);
        Lock writeLock=readWriteLock.writeLock();
        try {
            writeLock.lock();
            capacity.add(product);
        } finally {
            writeLock.unlock();
            System.out.println(Thread.currentThread().getName()+"结束添加仓库内的商品"+product);
        }
    }

    public int size(){
        Lock readLock=readWriteLock.readLock();
        try {
            readLock.lock();
            return capacity.size();
        } finally {
            readLock.unlock();
        }
    }
}
