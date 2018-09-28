package designPattern.single;

/**
 * 单例的四种方式
 * @author jianweilin
 * @date 2018/6/9
 */
public class SinglePattern {
    private static SinglePattern singlePattern;

    private SinglePattern() {
    }

    public static SinglePattern getInstance(){
        if(singlePattern == null){
            singlePattern = new SinglePattern();
        }
        return singlePattern;
    }
}
