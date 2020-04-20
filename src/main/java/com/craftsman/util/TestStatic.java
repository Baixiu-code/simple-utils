package com.craftsman.util;

/**
 * @author baixiu
 * @date 2019-03-11
 */
public class TestStatic {
    private static int i=0;
    {
        System.out.println("just block");
    }
    static {
        i=9;
        System.out.println("static block");
    }

    public static void  printI(){
        System.out.println("static method print:"+i);
    }
    public static void main(String[] args) {
        System.out.println("static main");
        TestStatic ts=new TestStatic();
        TestStatic ts1=new TestStatic();
        ts.toString();
        TestStatic.printI();
        System.out.println("i:"+i);
    }
}
