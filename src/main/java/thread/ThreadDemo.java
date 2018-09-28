package thread;

import java.util.stream.IntStream;

/**
 * @author jianweilin
 * @date 2018/4/25
 */
public class ThreadDemo {
    public static class Task1 implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " start");
            IntStream.range(1,10).forEach(num -> System.out.println(String.format("threadName: %s, num = %d",Thread.currentThread().getName(),num)));
            System.out.println(Thread.currentThread().getName() + " end");
        }
    }

    public static class Task2 implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " start");
            IntStream.range(10,20).forEach(num -> System.out.println(String.format("threadName: %s, num = %d",Thread.currentThread().getName(),num)));
            System.out.println(Thread.currentThread().getName() + " end");
        }
    }

    public static void joinTest(){
        Thread task1 = new Thread(new Task1(),"task1");
        Thread task2 = new Thread(new Task2(),"task2");
        task1.start();
        try {
            task1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task2.start();
    }

    public static void common(){
        Thread task1 = new Thread(new Task1(),"task1");
        Thread task2 = new Thread(new Task2(),"task2");
        task1.start();
        task2.start();
    }

    public static void main(String[] args) {
        joinTest();
    }


}
