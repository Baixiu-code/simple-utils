package test.base.structure.thread;

/**
 * @Author chenfanglin 【chenfanglincfl@163.com】
 * @Date 2017/5/318:27
 */
public class TestInterrupted extends Thread {
    @Override
    public void run() {
        System.out.println("test interrupted ");
    }

    public static void main(String[] args) {
        TestInterrupted testInterrupted=new TestInterrupted();
        testInterrupted.start();
        testInterrupted.interrupt();
        System.out.println("当前main线程状态0："+testInterrupted.interrupted());
        System.out.println("当前testInterrupted线程状态1："+testInterrupted.isInterrupted());
        System.out.println("当前testInterrupted线程状态2："+testInterrupted.isInterrupted());
        Thread.currentThread().interrupt();
        System.out.println("当前main线程状态1："+testInterrupted.interrupted());
        System.out.println("当前main线程状态2："+testInterrupted.interrupted());
    }
}
