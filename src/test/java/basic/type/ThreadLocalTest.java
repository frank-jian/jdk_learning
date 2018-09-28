package basic.type;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.stream.IntStream;

/**
 * @author jianweilin
 * @date 2018/4/22
 */
@RunWith(JUnit4.class)
public class ThreadLocalTest {

    @Test
    public void test_001(){
        ThreadLocal<Double> threadLocal = new ThreadLocal<>();
        IntStream.range(1,3).forEach(num ->
            new Thread(() -> {
                threadLocal.set(Math.random());
                System.out.println(String.format("当前线程：%s, threadlocal: %.2f",Thread.currentThread().getName(),threadLocal.get()));
            },"测试线程-"+num).start()
        );
    }

    @Test
    public void test_002(){
        ThreadLocal<String> hello = new ThreadLocal<>();
        try {
            hello.set("Hello World!");
        }finally {
            hello.remove();
        }
    }
}
