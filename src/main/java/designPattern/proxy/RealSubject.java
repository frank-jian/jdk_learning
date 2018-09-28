package designPattern.proxy;

/**
 * @author jianweilin
 * @date 2018/6/10
 */
public class RealSubject implements Subject{

    @Override
    public void buyMacPro() {
        System.out.println("买一台Mac Pro电脑");
    }
}
