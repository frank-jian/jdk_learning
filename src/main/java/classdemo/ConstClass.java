package classdemo;

/**
 * @author jianweilin
 * @date 2018/6/7
 */
public class ConstClass {
    static {
        System.out.println("ConstClass init!");
    }

    public static final String HELLO_WORLD = "hello world!";
}
