package test.base.structure.thread;


/**
 * @Author chenfanglin 【chenfanglincfl@163.com】
 * @Date 2017/5/317:30
 */
public class TestYieldThread extends  Thread {
    @Override
    public void run() {
        try {
              long beginTime=System.currentTimeMillis();
              Thread.yield();
              Thread.sleep(1000);
              long endTime=System.currentTimeMillis();
              System.out.println("yield 耗时："+(endTime-beginTime));
              beginTime=System.currentTimeMillis();
              Thread.sleep(1000);
              endTime=System.currentTimeMillis();
              System.out.println("正常耗时："+(endTime-beginTime));
        } catch (InterruptedException e) {
              e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread thread=new Thread(new TestYieldThread(),"a");
        thread.start();
    }
}
