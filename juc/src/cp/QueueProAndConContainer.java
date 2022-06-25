package cp;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class QueueProAndConContainer {
    private static final int size = 5;
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(size);

    public static void main(String[] args) {
        new QueueProAndConContainer().start();
    }

    private void start() {
        new Thread(new Producer(), "produce01").start();
        new Thread(new Consumer(), "consume01").start();
        new Thread(new Consumer(), "consume02").start();
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
//                    if (queue.size() == size) {
//                        System.out.println("Producer wait");
//                    }
                    queue.put(new Random().nextInt());
                    System.out.println(Thread.currentThread().getName() + "生产者生产 = " + queue.peek());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(2000);
//                    if (queue.isEmpty()) {
//                        System.out.println("Consumer wait");
//                    }
                    // 阻塞队列的内部实现就是 Lock + Condition
                    // 所以不需要再另外加锁
                    int x = queue.take();
                    System.out.println(Thread.currentThread().getName() + " 消费者消费 = " + x);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
