package concurrent.tools.cyclic;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author jianweilin
 * @date 2018/6/9
 */
public class Athlte implements Runnable {
    private CyclicBarrier cyclicBarrier;
    private String sportName;

    public Athlte(CyclicBarrier cyclicBarrier, String sportName) {
        this.cyclicBarrier = cyclicBarrier;
        this.sportName = sportName;
    }

    @Override
    public void run() {
        System.out.println(sportName + "就位");
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        double time = new Random().nextDouble() + 9;
        System.out.println(sportName + " : " + time);
    }
}
