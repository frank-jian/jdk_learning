package threadpool;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * @author jianweilin
 * @date 2018/4/13
 */
public class ThreadPoolDemo {
    public static void fixedThread(){
        ExecutorService executor = Executors.newFixedThreadPool(5);

        IntStream.range(1,10).boxed().forEach(num -> executor.execute(new WorkThread("" + num)));
        executor.shutdown();
        while (!executor.isTerminated()){}

        System.out.println("Finished all threads");
    }

    public static void definedThreadPool() throws InterruptedException {
        RejectedExecutionHandler rejectHandler = new RejectedExecutionHandlerImpl();
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        ThreadPoolExecutor executorPool = new ThreadPoolExecutor(2,4,1, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(2),threadFactory,rejectHandler);
        MonitorThread monitorThread = new MonitorThread(executorPool,1);

        // 启动监控线程
        new Thread(monitorThread).start();

        // 开始工作线程池
        IntStream.range(0,10).boxed().forEach(num -> executorPool.execute(new WorkThread("cmd " + num)));

        // 关闭线程池
        Thread.sleep(1000);
        executorPool.shutdown();

        // 关闭监控线程
        Thread.sleep(500);
        monitorThread.shutdown();
    }
    public static void main(String[] args) throws InterruptedException {
        definedThreadPool();
    }

}
