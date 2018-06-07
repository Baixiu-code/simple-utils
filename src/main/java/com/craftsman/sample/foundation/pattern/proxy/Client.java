package com.craftsman.sample.foundation.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author chenfanglin 【chenfanglincfl@163.com】
 * @Date 2017/2/1818:25
 */
public class Client {
    public static void main(String[] args) {
        Boss boss=new Boss();
        InvocationHandler handler=new DynamicProxy(boss);
        Hello hello=(Hello) Proxy.newProxyInstance(handler.getClass().getClassLoader(),boss.getClass().getInterfaces(),handler);
        hello.sayHello("你好");
    }
}
