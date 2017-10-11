package test.base.structure.thread;


import org.junit.Test;

/**
 * @Author chenfanglin 【chenfanglincfl@163.com】
 * @Date 2017/4/2717:46
 */
public class TestThread extends  Thread{
    @Override
    public void run() {
        int i=9;
        while (true && i>0){
            System.out.println(Thread.currentThread().getName()+(i--));
        }
    }

    public static void main(String[] args) {
        TestThread testThread=new TestThread();
        Thread thread=new Thread(testThread,"a");
        thread.start();
    }
}
