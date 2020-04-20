package com.craftsman.sample.foundation.pattern.singleton;


import com.craftsman.sample.foundation.thread.TestThread;

/**
 * @Author chenfanglin 【chenfanglincfl@163.com】
 * @Date 2017/4/2717:37
 */
public class TestSingleton {

    public static TestSingleton singleton;

    /**
     * 实现延迟初始化的优
     * 化问题隐患
     * @return
     */
    public static TestSingleton getSingleton(){
        if (singleton==null){
            synchronized (TestSingleton.class){
                singleton= new TestSingleton();
            }
        }else{
            return singleton;
        }
        return singleton;
    }
    /**普通synchronized同步获取单例方法方式来获取单例对象，这种方式对比上
     * 个方法。无论在任何时候都需要进行排队进行同步获取，其实本身我们的目的是
     * 在获取第二个对象是来获取对象的实例*/
    public static  synchronized TestSingleton getSingleton2(){
            if (singleton==null){
                singleton=new TestSingleton();
            }else{
                return singleton;
            }
            return singleton;
    }

    public static void main(String[] args) {

        System.out.println(getSingleton());
        TestThread testThreadSingletonThread=new TestThread();
        Thread threadA=new Thread(testThreadSingletonThread,"a");
        Thread threadB=new Thread(testThreadSingletonThread,"b");
        Thread threadC=new Thread(testThreadSingletonThread,"c");
        threadA.start();
        threadB.start();
        threadC.start();
    }
}
