package designPattern.single;

/**
 * @author jianweilin
 * @date 2018/6/9
 */
public class SinglePattern2 {
    private static SinglePattern2 singlePattern2 = new SinglePattern2();

    private SinglePattern2() {
    }

    public static SinglePattern2 getInstance(){
        return singlePattern2;
    }
}
