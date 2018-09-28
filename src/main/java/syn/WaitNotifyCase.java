package syn;

import java.util.concurrent.TimeUnit;

/**
 * 用于普通方法就是对象实例锁；
 * 用于静态方法就是对象锁；
 * wait notify 使用于只有两个线程的时候;
 * @author jianweilin
 * @date 2018/6/9
 */
public class WaitNotifyCase {

    static void Sort(int [] array) {
        // synchronize this operation so that some other thread can't
        // manipulate the array while we are sorting it. This assumes that other
        // threads also synchronize their accesses to the array.
        synchronized(array) {
            // now sort elements in array
        }
    }

    public static void main(String[] args) {
        final Object lock = new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread A is waiting to go lock");
                synchronized (lock) {
                    try {
                        System.out.println("Thread A get lock");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("thread A do wait method");
                        lock.wait();
                        System.out.println("wait end");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread B is waiting to go lock");
                synchronized (lock) {
                    System.out.println("Thread B get lock");
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread B do notify method start");
                    lock.notify();
                    System.out.println("thread B do notify method end");
                }
            }
        }).start();
    }
}
