package threadlocal;

import java.util.stream.IntStream;

/**
 * @author jianweilin
 * @date 2018/4/22
 */
public class Demo {
    private final double random = random();

    public static double random(){
        return Math.random();
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        IntStream.range(0,10).forEach(num ->{
            System.out.println(String.format("运行第%d次: random的值：%.2f", num,demo.random));
        });
    }
}
