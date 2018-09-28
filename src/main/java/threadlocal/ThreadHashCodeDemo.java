package threadlocal;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author jianweilin
 * @date 2018/4/22
 */
public class ThreadHashCodeDemo {
    private final int hashCode = nextHashCode();

    private static AtomicInteger nextHashCode = new AtomicInteger();

    public static int nextHashCode() {
        return nextHashCode.getAndAdd(1);
    }

    public static void main(String[] args) {
        IntStream.range(0,10).forEach(num -> {
            ThreadHashCodeDemo demo = new ThreadHashCodeDemo();
            System.out.println(String.format("运行第%d次，当前的hashCode：%d",num,demo.hashCode));
        });
    }
}
