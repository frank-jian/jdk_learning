package deadlock;

import java.util.stream.IntStream;

/**
 * @author jianweilin
 * @date 2018/6/8
 */
public class DeadLock {
    static class SynAdd implements Runnable{
        int a,b;

        public SynAdd(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (Integer.valueOf(a)){
                synchronized (Integer.valueOf(b)){
                    System.out.println(a+b);
                }
            }
        }
    }

    public static void main(String[] args) {
        IntStream.range(0,1000).forEach(i -> {
            new Thread(new SynAdd(1,2)).start();
            new Thread(new SynAdd(2,1)).start();
        });
    }
}
