package jvm;

/**
 * @author jianweilin
 * @date 2018/3/14
 */
public class CpuMax {
    public static void main(String[] args) {
        for(int i =0 ; i < 10 ; i ++){
            new Thread(() -> {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        Thread t = new Thread(() -> {
            int i = 0;
            while (true){
                i = (i++) /100;
            }
        });

        t.setName("Business Thread");
        t.start();

    }
}
