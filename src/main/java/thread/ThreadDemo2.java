package thread;

import java.util.stream.IntStream;

/**
 * @author jianweilin
 * @date 2018/4/25
 */
public class ThreadDemo2 {
   public static class Task implements Runnable {

       @Override
       public void run() {
           IntStream.range(0,5).forEach(num -> {
               if(num % 5 == 0){
                   System.out.println(String.format("%s yield controling ....",Thread.currentThread().getName()));
                   Thread.yield();
               }
           });
           System.out.println(String.format("%s has finished executing.",Thread.currentThread().getName()));
       }
   }

   public static class Task2 implements Runnable{
       @Override
       public void run() {
            IntStream.range(0,100).forEach(num -> System.out.println(" num => " + num));
       }
   }

    public static void main(String[] args) {
       Task2 task2 = new Task2();
       Thread t1 = new Thread(task2,"测试线程2");
       t1.start();
       t1.interrupt();
       System.out.println("是否停止: " + t1.interrupted());
       System.out.println("是否停止: " + t1.isInterrupted());
    }
}
