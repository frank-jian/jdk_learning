package basicType;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author jianweilin
 * @date 2018/4/21
 */
public class TestDemo {
    private final int localHashCode = nextHashCode();

    private static AtomicInteger nextHashCode = new AtomicInteger();

    public static int nextHashCode(){
       return nextHashCode.getAndAdd(1);
    }

    public static void main(String[] args) {
        TestDemo demo = new TestDemo();
        IntStream.range(0,10).forEach(num -> {
            System.out.println(num + " ： " + demo.localHashCode);
        });
    }
}
