package com.craftsman.sample.foundation.aop.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author chenfanglin 【chenfanglincfl@163.com】
 * @Date 2017/5/1014:53
 */
public class TestCglib {
    private static class MethodInterceptorImpl implements MethodInterceptor{
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println(method+"excute");
            methodProxy.invokeSuper(o,objects);
            return null;
        }
    }
    public static void main(String[] args) {
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(TestCglibMain.class);
        enhancer.setCallback(new MethodInterceptorImpl());
        TestCglibMain testCglib=(TestCglibMain)enhancer.create();
        testCglib.print();
    }
}
