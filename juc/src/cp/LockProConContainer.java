package cp;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockProConContainer {
    Lock lock = new ReentrantLock();
    Condition notFull = lock.newCondition();
    Condition notEmpty = lock.newCondition();
    Queue<Integer> queue = new LinkedList<>();
    final int size = 10;
    public static void main(String[] args) {
        new LockProConContainer().start();
    }

    private void start() {
        new Thread(new Consumer(),"consume01").start();
        new Thread(new Consumer(), "consume02").start();
        new Thread(new Producer(), "produce01").start();
//        new Thread(new Producer(), "produce02").start();
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
                    int consume = queue.poll();
                    System.out.println(Thread.currentThread().getName() + ", consume = " + consume);
                    notFull.signalAll();
                } finally {
                    lock.unlock();
                }

                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
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
                    queue.offer(new Random().nextInt());
                    System.out.println(Thread.currentThread().getName() + ", producer = " + queue.peek());
                    notEmpty.signalAll();
                } finally {
                    lock.unlock();
                }

                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
