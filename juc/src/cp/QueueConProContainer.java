package cp;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class QueueConProContainer {
    private static final int size = 5;
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(size);

    public static void main(String[] args) {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        new Thread(producer).start();
        new Thread(consumer).start();
        new Thread(new Consumer()).start();

    }

    static class Producer implements Runnable{

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                    if (queue.size() == size) {
                        System.out.println("Producer wait");
                    }
                    queue.put(new Random().nextInt());
                    System.out.println(Thread.currentThread().getName() + "生产者生产 ");
                } catch (InterruptedException e) {

                }
            }
        }
    }

    static class Consumer implements Runnable{
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(2000);
                    if (queue.isEmpty()) {
                        System.out.println("Consumer wait");
                    }
                    int x = queue.take();
                    System.out.println(Thread.currentThread().getName() + "消费者消费了 " + x + ", 队列中元素 " + queue.size());
                } catch (InterruptedException e) {

                }
            }
        }
    }

}
