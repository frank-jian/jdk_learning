package concurrent.tools.countDownLatch;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch用法；
 * @author jianweilin
 * @date 2018/6/9
 */
public class Application {
    private CountDownLatch latch;


    public Application(CountDownLatch latch) {
        this.latch = latch;
    }

    public void bootstrap() throws InterruptedException {
        List<Service> checkServices = Arrays.asList(new HealthService(latch),new DatabaseCheckService(latch));
        ExecutorService threadPools = Executors.newFixedThreadPool(checkServices.size());
        checkServices.forEach(service -> threadPools.execute(service));
        latch.await();
        System.out.printf("all service has checked");
        System.out.println("shut donw thread pool");
        threadPools.shutdown();


    }
    public static void main(String[] args) throws InterruptedException {
        new Application(new CountDownLatch(2)).bootstrap();
    }
}
