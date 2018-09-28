package thread;

import java.util.stream.IntStream;

/**
 * @author jianweilin
 * @date 2018/5/20
 */
public class ThreadDemo5 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1= new Thread(() -> {
            IntStream.range(0,10).forEach(num -> {
                System.out.println("当前输出的值num为：" + num);
            });
        });

        t1.start();
        t1.join();
        System.out.println("这是主线程");
    }
}
