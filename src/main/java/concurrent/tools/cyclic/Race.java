package concurrent.tools.cyclic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jianweilin
 * @date 2018/6/9
 */
public class Race {
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

    public static void main(String[] args) {
        List<Athlte> sporters = new ArrayList<>();
        sporters.add(new Athlte(cyclicBarrier,"博尔特"));
        sporters.add(new Athlte(cyclicBarrier,"刘翔"));
        sporters.add(new Athlte(cyclicBarrier,"古奇"));
        ExecutorService threadpools = Executors.newFixedThreadPool(4);
        sporters.forEach(sporter -> threadpools.execute(sporter));
        System.out.println("所有人都已经就位！");
        threadpools.shutdown();
    }
}
