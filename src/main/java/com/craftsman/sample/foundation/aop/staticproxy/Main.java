package com.craftsman.sample.foundation.aop.staticproxy;

/**
 * main client
 */
public class Main {
    public static void main(String[] args) {
        Run run=new DogStaticProxy();
        run.run();
    }
}
