package com.craftsman.sample.foundation.pattern.singleton;

/**
 * 一般的双重检查锁的方式单例类实现
 * 漏洞：由于操作系统在底层执行代码程序时会进行指令重排的机制，
 * 而在以下这段代码中，instance=new NormalSingleton();
 * 这段操作对应到操作系统底层存在三个步骤
 * a.开辟一段内存空间
 * b.利用NormalSingleton的默认构造函数进行实例化
 * c.将instance引用指向实例化对象
 * 一般情况下安装a->b->c 执行，而当遇到以下两个条件时就会出现问题
 * 1.操作系统对于程序指令进行指令重排
 * 就会出现a->c->b 这种情况
 * 2.多个线程同时获取单例，这时候当线程1执行到a->c的操作，这时候instance指向了实例化对象，这时候
 * instance！=null.而instance没有进行构造。大家都知道我们的cpu是进行时间片轮转进行
 * 运行。这时候线程1挂起，线程2进入a步骤，这时候判断instance非空那么就直接返回了一个没有进行构造的实例化对象
 * 程序异常。
 * @author chenfanglin
 * @desc
 */
public class DoubleCheckSingleton {
    private DoubleCheckSingleton instance;
    public DoubleCheckSingleton getInstance(){
        if(instance==null){
            synchronized (DoubleCheckSingleton.class){
                if(instance==null){
                    instance=new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}
