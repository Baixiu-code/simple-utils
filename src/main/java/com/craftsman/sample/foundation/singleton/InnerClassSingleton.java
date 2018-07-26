package com.craftsman.sample.foundation.singleton;

/**
 * 内部类实现单例
 * 由于内部类的初始化是在外部进行调用进行初始化，
 * 在初始化之后一直会驻留在内存中
 * @author chenfanglin
 * @desc 内部类实现初始化
 */
public class InnerClassSingleton {
    static class InnerClassInstance{
        static final InnerClassSingleton innerClassInstance=new InnerClassSingleton();
    }
    public static InnerClassSingleton getInstance(){
        return InnerClassInstance.innerClassInstance;
    }
}
