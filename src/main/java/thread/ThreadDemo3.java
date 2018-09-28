package thread;

/**
 * @author jianweilin
 * @date 2018/5/4
 */
public class ThreadDemo3 {
    public static void startProject(){
        new Thread(() -> System.out.println(Thread.currentThread().getName() + " : start Hello World!"),"start分支线程").start();
    }

    public static void runProject(){
        new Thread(() -> System.out.println(Thread.currentThread().getName() + " : run Hello World!"),"run分支线程").run();
    }

    public static void main(String[] args) {
        System.out.println(String.format("当前线程是：%s, 执行Hello World.",Thread.currentThread().getName()));
//        startProject();
        runProject();


    }
}
