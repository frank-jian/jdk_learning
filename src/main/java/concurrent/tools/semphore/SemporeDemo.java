package concurrent.tools.semphore;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

/**
 * @author jianweilin
 * @date 2018/6/9
 */
public class SemporeDemo {
    private final static int THREAD_COUNT = 10;
    private final static Semaphore semaphore = new Semaphore(5);
    private final static ExecutorService threadPools = Executors.newFixedThreadPool(THREAD_COUNT);

    public static void main(String[] args) {
        IntStream.range(0,THREAD_COUNT).forEach(num -> {
            threadPools.execute(new WorkTask(semaphore));
        });

        System.out.println("thread pools shut down");
        threadPools.shutdown();
    }

    static class WorkTask implements Runnable {
        private Semaphore semaphore;

        public WorkTask(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            Integer randomInt = + new Random().nextInt(10);
            System.out.println(String.format("ThreadName: %s, 读取文件数 : %d ",Thread.currentThread().getName(),randomInt));
            try {
                semaphore.acquire();
                System.out.println(String.format("ThreadName: %s, 存入数据库 : %d ",Thread.currentThread().getName(),randomInt));
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
