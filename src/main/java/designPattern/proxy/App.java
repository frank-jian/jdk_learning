package designPattern.proxy;

/**
 * @author jianweilin
 * @date 2018/6/10
 */
public class App {
    public static void main(String[] args) {
        Proxy proxy = new Proxy(new RealSubject());
        proxy.buyMacPro();
    }
}
