package com.craftsman.sample.foundation.aop.staticproxy;

/**
 * dog static proxy
 * @author chenfanglin
 * @desc dog 静态代理
 */
public class DogStaticProxy implements Run {

    private Dog dog;

    public DogStaticProxy(){
        this.dog=new Dog();
    }
    @Override
    public void run() {
        beforeRun();
        dog.run();
        afterRun();
    }

    private void beforeRun(){
        System.out.println("before run.prepare for run ");
    }

    private void afterRun(){
        System.out.println("after run.need take a break");
    }
}
