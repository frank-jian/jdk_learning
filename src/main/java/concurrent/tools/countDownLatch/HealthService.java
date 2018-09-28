package concurrent.tools.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author jianweilin
 * @date 2018/6/9
 */
public class HealthService extends Service {

    public HealthService(CountDownLatch latch) {
        super(latch);
    }

    @Override
    public void execute() {
        try {
            System.out.println("health service check");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
