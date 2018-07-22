package com.craftsman.sample.foundation.aop.aspectj;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * jdk dynamic proxy
 * @author chenfanglin
 * @desc jdk 动态代理
 */
public class JDKDynamicProxy implements InvocationHandler {

    private Object target;

    public JDKDynamicProxy(Object target){
        this.target=target;
    }
    @SuppressWarnings("unchecked")
    public <T> T getProxy(){
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result= method.invoke(target,args);
        after();
        return result;
    }

    public void before(){
        System.out.println("jdk dynamic Proxy before invoke ");
    }

    public void after(){
        System.out.println("jdk dynamic Proxy after invoke ");
    }


}
