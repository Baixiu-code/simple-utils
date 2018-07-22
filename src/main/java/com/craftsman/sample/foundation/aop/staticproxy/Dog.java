package com.craftsman.sample.foundation.aop.staticproxy;

/**
 * Dog run 方法
 */
public class Dog implements Run {

    @Override
    public void run() {
        System.out.println("dog run");
    }

}
