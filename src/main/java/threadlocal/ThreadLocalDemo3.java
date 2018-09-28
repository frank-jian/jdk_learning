package threadlocal;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author jianweilin
 * @date 2018/4/21
 */
public class ThreadLocalDemo3 {
    private final int threadLocalHashCode = nextHashCode();

    private static AtomicInteger nextHashCode =
            new AtomicInteger();


    private static final int HASH_INCREMENT = 0x61c88647;

    private static int nextHashCode() {
        return nextHashCode.getAndAdd(HASH_INCREMENT);
    }

    public static void main(String[] args) {
        ThreadLocalDemo3 local = new ThreadLocalDemo3();
//        System.out.println(local.threadLocalHashCode);
//        System.out.println(nextHashCode.get());
        IntStream.range(0,3).forEach((int num) -> {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(String.format("%s : local = %d",Thread.currentThread().getName(),nextHashCode()));
                }
            },"线程: " + num).start();
        });
    }
}
