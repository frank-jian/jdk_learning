package concurrent.tools.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author jianweilin
 * @date 2018/6/9
 */
public class DatabaseCheckService extends Service{
    public DatabaseCheckService(CountDownLatch latch) {
        super(latch);
    }

    @Override
    public void execute() {
        try {
            System.out.println("database service check");
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
