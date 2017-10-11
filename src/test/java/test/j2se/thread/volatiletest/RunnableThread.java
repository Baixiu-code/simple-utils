package test.j2se.thread.volatiletest;

/**
 * @Author chenfanglin 【chenfanglincfl@163.com】
 * @Date 2017/2/2111:21
 */
public class RunnableThread extends Thread {
    private  boolean isRunning=true;

    public boolean isRunning(){
        return isRunning;
    }
    public void setRunning(boolean isRunning){
        System.out.println("设置isRunning:"+isRunning);
        this.isRunning=isRunning;
    }

    @Override
    public void run() {
        System.out.println("start running");
        while (isRunning()==true){
            System.out.println("循环:"+isRunning);
        }
        System.out.println("break loop:"+isRunning());
    }
}