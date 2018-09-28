package designPattern.proxy;

/**
 * @author jianweilin
 * @date 2018/6/10
 */
public class Proxy implements Subject{
    private RealSubject realSubject;

    public Proxy(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void buyMacPro() {
        // 调用真实对象的方法；
        realSubject.buyMacPro();

        // 代理层面额外做的；
        doByProxy();
    }

    public void doByProxy(){
        System.out.println("把Mac Pro 包装好");
    }
}
