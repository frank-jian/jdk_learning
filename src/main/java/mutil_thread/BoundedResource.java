package mutil_thread;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

/**
 * @author jianweilin
 * @date 2018/7/13
 */
public class BoundedResource {
    private final Semaphore semaphore;
    private final int permits;
    private final static Random random = new Random(31231);

    public BoundedResource(int permits) {
        this.permits = permits;
        this.semaphore = new Semaphore(permits);
    }

    public void use() throws InterruptedException {
        semaphore.acquire();
        try {
            doUse();
        }finally {
            semaphore.release();
        }
    }

    protected void doUse() throws InterruptedException {
        Log.println("BEGIN: used = " + (permits - semaphore.availablePermits()));
        Thread.sleep(random.nextInt(500));
        Log.println("END: used = " + (permits - semaphore.availablePermits()));
    }
}

class Log {
    public static void println(String s){
        System.out.println(Thread.currentThread().getName() + ": " + s);
    }
}

class UserThread extends Thread{
    private final static Random random = new Random(2312);
    private final BoundedResource boundedResource;

    public UserThread(BoundedResource boundedResource){
        this.boundedResource = boundedResource;
    }


    @Override
    public void run() {
        while (true){
            try {
                boundedResource.use();
                Thread.sleep(random.nextInt(300));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        BoundedResource resouce = new BoundedResource(3);

        IntStream.range(0,10).forEach(i -> new UserThread(resouce).start());
    }
}
