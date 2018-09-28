package votiles;

import java.util.stream.IntStream;

/**
 * @author jianweilin
 * @date 2018/6/9
 */
public class VolatileDemo {
    public static volatile int race = 0;

    public static void increase(){
        race++;
        System.out.println(String.format("ThreadName: %s, thread race = %d",Thread.currentThread().getName(),race));
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) {
        IntStream.range(0,THREADS_COUNT).forEach(i -> new Thread(() -> {
           IntStream.range(0,10000).forEach(j -> increase());
        },String.format("线程-%d",i)).start());

        while (Thread.activeCount() > 1){
            System.out.println(String.format("activeCount = %d",Thread.activeCount()));
            Thread.yield();
        }
        System.out.println(String.format("ThreadName: %s, final race = %d",Thread.currentThread().getName(),race));
    }
}
