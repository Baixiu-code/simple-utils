package com.craftsman.sample.foundation;

/**
 * @Author chenfanglin 【chenfanglincfl@163.com】
 * @Date 2017/4/2619:38
 */
public class TestExcuteSortSuper {
    static {
        System.out.println("super static code block excute");
    }
    public void TestExcuteSort(){
        System.out.println("super method excute ");
    }
    public void TestSuperMethodSort(){
        System.out.println("super method excute");
    }
    public TestExcuteSortSuper(){
        System.out.println("super construct");
    }


}
