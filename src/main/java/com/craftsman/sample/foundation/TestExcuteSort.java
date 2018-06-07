package com.craftsman.sample.foundation;

/**
 * @Author chenfanglin 【chenfanglincfl@163.com】
 * @Date 2017/4/2619:37
 */
public class TestExcuteSort extends TestExcuteSortSuper {
    static {
        System.out.println("child static code block excute");
    }
    public TestExcuteSort(){
        System.out.println("child construct");
    }
    @Override
    public void TestExcuteSort(){
        System.out.println("child method excute");
    }
    public void TestChildMethodExcute(){
        System.out.println("child method excute");
    }

    /**
     * 测试代码的执行顺序
     * 1.首先执行静态代码块的代码，如果该类存在父类，则首先执行父类的
     * 静态代码块代码，然后执行子类代码块
     * 2.然后执行构造函数代码，如果该类存在父类，则首先执行父类构造函数
     * ，然后执行子类构造函数
     * 3.然后顺序执行父类的方法，然后执行子类的构造方法
     * 总体上顺序：父类静态代码块--》子类静态代码块--》父类构造函数--》子类构造函数
     * --》父类方法
     * @param args
     */
    public static void main(String[] args) {
        TestExcuteSortSuper testExcuteSort=new TestExcuteSort();
        testExcuteSort.TestSuperMethodSort();
    }
}
