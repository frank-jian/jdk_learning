package atom;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author jianweilin
 * @date 2018/5/19
 */
public class AtomicDemo {
    private AtomicInteger num = new AtomicInteger(0);

    public void add(){
//        num = ++ num;
        num.getAndIncrement();
        System.out.println(String.format("线程：%s, num = %d", Thread.currentThread().getName(),num.get()));
    }

    public int get(){
        return num.get();
    }

    public static void main(String[] args) {
        AtomicDemo demo = new AtomicDemo();

        IntStream.range(0,2).forEach(i -> {
            new Thread(() -> {
                IntStream.range(0,10).forEach(j -> demo.add());
            },"线程- " +i).start();
        });

        System.out.println("final result = " + demo.get());
    }
}
