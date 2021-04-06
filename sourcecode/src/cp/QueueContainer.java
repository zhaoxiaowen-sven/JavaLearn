package cp;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class QueueContainer {
    private static final int size = 5;
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(size);

    public static void test() {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    producer.produce(0);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    consumer.consumer(0);
                }
            }
        }).start();

    }

    static class Producer {
        public void produce(int i) {
            try {
                if (queue.size() == size) {
                    System.out.println("Producer wait");
                }
                queue.put(i);
                System.out.println(Thread.currentThread().getName() + "生产者生产 " + i + ", 目前总共有 " + queue.size());
            } catch (InterruptedException e) {

            }
        }
    }

    static class Consumer {
        public void consumer(int i) {
            try {
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



