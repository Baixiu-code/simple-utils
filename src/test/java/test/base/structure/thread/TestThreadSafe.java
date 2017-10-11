package test.base.structure.thread;


/**
 * @Author chenfanglin 【chenfanglincfl@163.com】
 * @Date 2017/5/218:21
 */
public class TestThreadSafe implements Runnable {
    private static  int safeNum=10;
    //private static volatile int safeNum=10;
    @Override
    synchronized  public void run() {
        while (safeNum>0){
            safeNum--;
            System.out.println(Thread.currentThread().getName()+safeNum);
        }
    }

    public static void main(String[] args) {
        TestThreadSafe thread=new TestThreadSafe();
        Thread thread1=new Thread(thread,"a");
        Thread thread2=new Thread(thread,"b");
        Thread thread3=new Thread(thread,"c");
        Thread thread4=new Thread(thread,"d");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
