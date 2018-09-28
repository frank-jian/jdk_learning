package concurrent.tools.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author jianweilin
 * @date 2018/6/9
 */
public class Service implements Runnable{
    private CountDownLatch latch;

    public Service(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            execute();
        }finally {
            if(latch != null){
                latch.countDown();
            }
        }
    }

    public void execute(){

    };
}
