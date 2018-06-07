package com.craftsman.sample.foundation.pattern.proxy;

/**
 * @Author chenfanglin 【chenfanglincfl@163.com】
 * @Date 2017/2/1818:21
 */
public class Secretary implements Hello {
    @Override
    public void sayHello(String helloContent) {
        System.out.println("secretary"+helloContent);
    }
}
