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
    private final Condition notFull = lock.newCondition();
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
                    while (queue.size() == size) {
                        try {
                            notFull.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.add(new Random().nextInt());
                    System.out.println("producer-- " + Thread.currentThread().getName() + "--put:" + queue.peekFirst());
                    notEmpty.signalAll(); // 这里注意要用singnal
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
//                            System.out.println("the list is empty........");
                            notEmpty.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int out = queue.poll();
                    System.out.println("consumer -- " + Thread.currentThread().getName() + "--put:" + out);
                    notFull.signalAll();
                } finally {
                    lock.unlock();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}