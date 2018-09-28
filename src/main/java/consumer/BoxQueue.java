package consumer;

import com.alibaba.fastjson.JSON;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.LongStream;

/**
 * 消费者与生成者 ReetrantLock 与Condition的版本；
 * @author jianweilin
 * @date 2018/6/10
 */
public class BoxQueue {
    private Box[] boxes;

    private Lock lock = new ReentrantLock();

    private Condition notFull = lock.newCondition();

    private Condition notEmpty = lock.newCondition();

    private int tail,head,count;

    public BoxQueue(Box[] boxes) {
        this.boxes = boxes;
    }

    public BoxQueue() {
        this.boxes = new Box[10];
    }

    public void produce(Box box) throws InterruptedException {

        lock.lock();
        try {
            System.out.println(String.format("boxes.length = %d, count = %d", boxes.length,count));
            while (boxes.length == count){
                notFull.await();
            }

            boxes[tail] = box;
            System.out.println(String.format("生成线程：%s，索引位：%d, 数据:%s",Thread.currentThread().getName(),
                    tail, JSON.toJSONString(box)));
            if(++tail == boxes.length){
                tail = 0;
            }
            ++count;
            notEmpty.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public Box consumer() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0){
                notEmpty.await();
            }
            Box box = boxes[head];
            System.out.println(String.format("消费线程：%s，索引位：%d, 数据:%s",Thread.currentThread().getName(),
                    head, JSON.toJSONString(box)));
            boxes[head] = null;
            if(++head == boxes.length){
                head = 0;
            }
            count --;
            notFull.signalAll();
            return box;
        }finally {
            lock.unlock();
        }
    }


    static class Box{
        private Long id;
        private String boxName;

        public Box(Long id, String boxName) {
            this.id = id;
            this.boxName = boxName;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getBoxName() {
            return boxName;
        }

        public void setBoxName(String boxName) {
            this.boxName = boxName;
        }
    }

    public static void bootstrap() throws InterruptedException {
        BoxQueue boxQueue = new BoxQueue();
        Thread t1 = new Thread(() -> {
            LongStream.range(0,12).forEach(i -> {
                try {
                    boxQueue.produce(new Box(i,String.format("第%d个箱子",i)));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        },"生成线程-1");

        Thread t2 = new Thread(() -> {
            try {
                boxQueue.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"消费线程-1");


        Thread t3 = new Thread(() -> {
            try {
                boxQueue.produce(new Box(111L,"测试数据"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"生成线程-2");

        t1.start();
        t2.start();
        t3.start();
        System.out.println(String.format("当前线程：%s，结束！\n\n",Thread.currentThread().getName()));
    }
    public static void main(String[] args) throws InterruptedException {
        bootstrap();
    }
}
