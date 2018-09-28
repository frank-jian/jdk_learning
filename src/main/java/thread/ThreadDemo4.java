package thread;

/**
 * @author jianweilin
 * @date 2018/5/4
 */
public class ThreadDemo4 {
    public static void main(String[] args) {
        ThreadDemo4 demo4 = new ThreadDemo4();
        demo4.interuptTest1();
    }

    public void interuptTest1(){
     Thread thread = new Thread(() -> {
         System.out.println("分支线程开始");
         while (true){}
     },"分支线程");
     thread.start();
     thread.interrupt();

     System.out.println("主线程RUN isInterrupted： " + thread.isInterrupted());
     System.out.println("主线程RUN interrupted ： " + Thread.interrupted());
    }

    public void interuptTest2(){
        Thread thread = new Thread(() -> System.out.println(Thread.currentThread().getName()+ " : HelloWorld！"),"分支线程");
        thread.start();
        thread.interrupt();
        System.out.println("主线程RUN interrupted ： " + Thread.interrupted());
        System.out.println("主线程RUN isInterrupted： " + thread.isInterrupted());
    }
}
