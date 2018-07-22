package com.craftsman.sample.foundation.aop.aspectj;

import com.craftsman.sample.foundation.aop.staticproxy.Dog;
import com.craftsman.sample.foundation.aop.staticproxy.Run;

/**
 * @author chenfanglin
 * @desc dynamic proxy client main
 */
public class Main {
    public static void main(String[] args) {
        Run run=new JDKDynamicProxy(new Dog()).getProxy();
        run.run();
    }
}
