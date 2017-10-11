package test.j2se.thread.volatiletest;

/**
 * @Author chenfanglin 【chenfanglincfl@163.com】
 * @Date 2017/2/2111:29
 */
public class Client {
    public static void main(String[] args) {
        RunnableThread runnableThread=new RunnableThread();
        runnableThread.start();
        try {
            runnableThread.sleep(1000);
            System.out.println("last time:"+runnableThread.isRunning());
            runnableThread.setRunning(false);
            System.out.println(runnableThread.isRunning());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
