package cp;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockProConContainer {
    private static final int size = 5;
    private Deque<Integer> queue = new LinkedList<>();
    private final Lock lock = new ReentrantLock();
    // 从唤醒的角度理解这2个名字含义
    // 表示"不满了"，可以生产了，唤醒生产者
    private final Condition notFull = lock.newCondition();
    // 表示生产者 "不空了"，唤醒消费者
    private final Condition notEmpty = lock.newCondition();

    public static void main(String[] args) {
        new LockProConContainer().start();
    }

    private void start() {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        new Thread(producer, "producer01").start();
        new Thread(consumer, "cousumer01").start();
        new Thread(new Consumer(), "cousumer02").start();
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    // while 判断
                    while (queue.size() == size) {
                        try {
                            // 阻塞
                            notFull.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.add(new Random().nextInt());
                    System.out.println(Thread.currentThread().getName() + "生产者生产 = " + queue.peekFirst());
                    // 表示生产者 "不空了"，唤醒消费者
                    // 这里注意要用signal
                    notEmpty.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (queue.size() == 0) {
                        try {
                            notEmpty.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int out = queue.poll();
                    System.out.println(Thread.currentThread().getName() + " 消费者消费 = " + out);
                    // 表示"不满了"，唤醒生产者
                    // 不可使用notify 唤醒
                    notFull.signalAll();
                } finally {
                    lock.unlock();
                }
                // 控制频率
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}