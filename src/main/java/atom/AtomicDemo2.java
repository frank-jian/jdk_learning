package atom;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author jianweilin
 * @date 2018/5/20
 */
public class AtomicDemo2 {
    private static AtomicInteger atomicInteger = new AtomicInteger(100);
    private static AtomicStampedReference atomicStampedReference = new AtomicStampedReference(100,1);

    public static void main(String[] args) throws InterruptedException {
        // AtomicInteger
        Thread at1 = new Thread(new Runnable() {
            @Override
            public void run() {
                atomicInteger.compareAndSet(100,110);
                atomicInteger.compareAndSet(110,100);
            }
        });

        Thread at2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2); // at1，执行完
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("AtomicInteger: " + atomicInteger.compareAndSet(100,120));
            }
        });
        at1.start();
        at2.start();
        at1.join();
        at2.join();

        // AtomicStampedReference
        Thread tsf1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 让tsf2先获取stamp，导致预期时间戳不一致
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 预期引用：100， 更新后的引用110，预期表示getStamp(), 更新后表示：getStamp() + 1
                atomicStampedReference.compareAndSet(100,110,atomicStampedReference.getStamp(),atomicStampedReference.getStamp() +1);
                System.out.println("100 -> 110: " + atomicStampedReference.getStamp());
                atomicStampedReference.compareAndSet(110,100,atomicStampedReference.getStamp(),atomicStampedReference.getStamp() +1);
                System.out.println("110 -> 100: " + atomicStampedReference.getStamp());

            }
        });

        Thread tsf2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int stamp = atomicStampedReference.getStamp();
                System.out.println("100 -> 120: " + stamp);
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("AtomicStampedReference: " + atomicStampedReference.compareAndSet(100,120,stamp,stamp+1));
            }
        });
        tsf1.start();
        tsf2.start();
    }
}
