package threadlocal;

/**
 * @author jianweilin
 * @date 2018/4/19
 */
public class ThreadLocalDemo2 {
    public static class MyTask implements Runnable {
        private Double random = new Double(0.0);
        @Override
        public void run() {
            random = Math.random() * 1000;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("threadName: %s, random: %.2f", Thread.currentThread().getName(),random));
        }
    }

    public static void main(String[] args) {
        MyTask task = new MyTask();
        new Thread(task,"测试线程3").start();
        new Thread(task,"测试线程4").start();
    }
}
