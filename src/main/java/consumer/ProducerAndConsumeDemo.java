package consumer;

import com.alibaba.fastjson.JSON;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 一个仓库只能放10个箱子；
 * 有一撮人，一些人往仓库里搬东西，仓库满了，就等着；
 * 有一撮人，往把仓库内的箱子搬走，仓库空了，就等着；
 *
 * @author jianweilin
 * @date 2018/6/8
 */
public class ProducerAndConsumeDemo {

    static class BoxProducer implements Runnable{
        private QueueBox box;
        private int produceCount;

        public BoxProducer(QueueBox box, int produceCount) {
            this.box = box;
            this.produceCount = produceCount;
        }

        @Override
        public void run() {
            box.producer(produceCount);
        }
    }

    static class BoxConsume implements Runnable{
       private QueueBox box;
       private int consumeCount;

        public BoxConsume(QueueBox box, int consumeCount) {
            this.box = box;
            this.consumeCount = consumeCount;
        }

        @Override
        public void run() {
            box.consume(consumeCount);
        }
    }


    static class QueueBox {
        private BlockingQueue<Box> blockingQueue;

        public QueueBox(BlockingQueue<Box> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        public void consume(int count){
            while (count -- > 0){
                try {
                    Box box = blockingQueue.take();
                    System.out.println(String.format("消费数据，box = 「%s」,被弹出", JSON.toJSONString(box)));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("consume blockqueue size = " + blockingQueue.size());
        }

        public void producer(int count){
            while (count -- > 0){
                try {
                    Box box = new Box((long)Math.random(),"随机数");
                    blockingQueue.put(box);
                    System.out.println(String.format("往队列里新增数据，box = 「%s」",JSON.toJSONString(box)));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("produce blockqueue size = " + blockingQueue.size());
        }
    }
    static class Box{
        Long boxId;
        String boxName;

        public Box(Long boxId, String boxName) {
            this.boxId = boxId;
            this.boxName = boxName;
        }

        public Long getBoxId() {
            return boxId;
        }

        public void setBoxId(Long boxId) {
            this.boxId = boxId;
        }

        public String getBoxName() {
            return boxName;
        }

        public void setBoxName(String boxName) {
            this.boxName = boxName;
        }
    }


    public static void main(String[] args) {
        BlockingQueue<Box> blockingQueue = new ArrayBlockingQueue<Box>(10);
        QueueBox box = new QueueBox(blockingQueue);
        BoxProducer producer = new BoxProducer(box,20);
        BoxConsume consumer = new BoxConsume(box,15);
        new Thread(producer,"生产者线程").start();
        new Thread(consumer,"消费线程").start();


    }
}
