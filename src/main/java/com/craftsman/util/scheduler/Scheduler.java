package com.craftsman.util.scheduler;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义定时任务
 */
public class Scheduler implements Runnable{

    private static AtomicInteger schedulerId = new AtomicInteger(0);
    private static Logger logger = LoggerFactory.getLogger("bootLogger");
    private volatile int threadId = 1;
    private volatile boolean running = false;

    private long SLEEP_TIME = 250L;
    private ExecutorService taskExecutor;
    private LinkedList<ScheduledTask> taskList;
    private LinkedList<ScheduledTask> addList;
    private String serviceName = "定时任务";

    public Scheduler(){
        schedulerId.incrementAndGet();
        this.taskList = new LinkedList<>();
        this.addList = new LinkedList<>();
    }

    public Scheduler(long interval){
        this();
        this.SLEEP_TIME = interval;
    }

    //init Scheduler
    public void init(){
        logger.info("start init ");
        this.running = true;
        this.taskExecutor = Executors.newSingleThreadExecutor();
        this.taskExecutor.execute(this);
    }

    //destroy Scheduler
    public void destroy(Object o){
        this.running = false;
        List<Runnable> leftOvers = this.taskExecutor.shutdownNow();
        this.taskExecutor = null;
        this.logger.info("Scheduler stopped. Unprocessed tasks: " + leftOvers.size());
    }

    //执行线程任务
    @Override
    public void run(){
        Thread.currentThread().setName("Scheduler" + schedulerId.get() + "-thread-" + this.threadId++);
        this.logger.info("Scheduler started: " + this.serviceName);

        while (this.running){
            try{
                //执行各自task的任务，并将新增的添加到addList队列
                executeTasks();
                //强制当前线程暂停执行 默认250s
                Thread.sleep(this.SLEEP_TIME);
            }catch (InterruptedException ie){
                this.logger.warn("Scheduler: " + this.serviceName + " interrupted.");
            }catch (Exception e){
                logger.error( "Scheduler: " + this.serviceName + " caught a generic exception: " + e, e);
            }
        }
    }

    /**
     * 添加一个任务到任务调度队列
     * @param interval -- 延迟多久开始执行
     * @param loop -- 是否循环执行
     * @param task -- 封装的任务接口，需要实现
     * @param param -- 任务接口的方法参数
     */
    public void addScheduledTask(int interval, boolean loop, Task task, Map<Object, Object> param){
        synchronized (this.addList){
            this.addList.add(new ScheduledTask(interval, loop, task, param));
        }
    }

    //执行线程
    private void executeTasks(){
        long now = System.currentTimeMillis();
        //1.执行任务
        if (this.taskList.size() > 0){
            synchronized (this.taskList){
                for (Iterator<ScheduledTask> it = this.taskList.iterator(); it.hasNext(); ){
                    ScheduledTask t = it.next();
                    if (now >= t.expiry){
                        try{
                            t.task.doTask(t.param);
                        }catch (Exception e){
                            logger.error("Scheduler callback exception. Callback: " + t.task + ", Exception: " + e, e);
                        }
                        if (t.loop){//如果循环执行，则在1000s之后执行
                            t.expiry += t.interval * 1000;
                        }else{//不循环，则直接移除该任务
                            it.remove();
                        }
                    }
                }
            }
        }
        //2.将新增的任务添加的任务列表
        if (this.addList.size() > 0){
            synchronized (this.taskList){
                this.taskList.addAll(this.addList);
                this.addList.clear();
            }
        }
    }
    @Data
    @NoArgsConstructor
    private final class ScheduledTask
    {
        long expiry;
        int interval;
        boolean loop;
        Task task;
        Map<Object, Object> param;

        public ScheduledTask(int interval, boolean loop, Task task, Map<Object, Object> param){
            this.interval = interval;
            this.expiry = (System.currentTimeMillis() + interval * 1000);
            this.task = task;
            this.loop = loop;
            this.param = param;
        }
    }
}

