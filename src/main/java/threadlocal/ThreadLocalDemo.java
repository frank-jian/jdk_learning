package threadlocal;

/**
 * @author jianweilin
 * @date 2018/4/18
 */
public class ThreadLocalDemo {
    public static class MyTask implements Runnable{
        private ThreadLocal<Double> threadLocal = new ThreadLocal<>();
        @Override
        public void run() {
            threadLocal.set(Math.random());
            System.out.println(String.format("thread name : %s, threadlocal: %.2f",Thread.currentThread().getName(), threadLocal.get()));
        }
    }

    public static void main(String[] args) {
        MyTask task = new MyTask();
        new Thread(task,"测试线程1").start();
        new Thread(task,"测试线程2").start();
    }
}
