package designPattern.single;

/**
 * 内部类的方式
 * @author jianweilin
 * @date 2018/6/9
 */
public class SinglePattern4 {
    private SinglePattern4() {
    }

    public static SinglePattern4 getInstance(){
        return SingleHelper.SINGLE_INSTANCT;
    }

    private static class SingleHelper{
        private static final SinglePattern4 SINGLE_INSTANCT = new SinglePattern4();
    }
}
