package designPattern.single;

/**
 * @author jianweilin
 * @date 2018/6/9
 */
public class SinglePattern3 {
    private static volatile SinglePattern3 singlePattern3;

    private SinglePattern3() {
    }

    public static SinglePattern3 getInstance(){
        if(singlePattern3 == null){
            synchronized (SinglePattern3.class){
                if(singlePattern3 == null){
                    singlePattern3 = new SinglePattern3();
                }
            }
        }
        return singlePattern3;
    }
}
