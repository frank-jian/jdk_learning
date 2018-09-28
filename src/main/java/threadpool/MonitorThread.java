package threadpool;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author jianweilin
 * @date 2018/4/13
 */
public class MonitorThread implements Runnable {
    private ThreadPoolExecutor executor;
    private int seconds;
    private boolean run = true;

    public MonitorThread(ThreadPoolExecutor executor, int seconds) {
        this.executor = executor;
        this.seconds = seconds;
    }

    public void shutdown(){
        this.run = false;
    }

    @Override
    public void run() {
        while (run){
            System.out.println(String.format("[monitor] [%d/%d] Active:%d, Completed:%d, Task:%d , isShutdown: %s, isTerminated :%s",
                    this.executor.getPoolSize(),this.executor.getMaximumPoolSize(),this.executor.getActiveCount(),this.executor.getCompletedTaskCount(),this.executor.getTaskCount(),this.executor.isShutdown(),this.executor.isTerminated()));
            try{
                Thread.sleep(seconds * 100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
