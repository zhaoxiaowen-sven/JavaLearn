package cp;

import java.util.LinkedList;
import java.util.Queue;

public class Container {
    private static final Object obj = new Object();
    private static final int size = 5;
    private static Queue<Integer> queue = new LinkedList<>();

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
            synchronized (obj) {
                while (queue.size() == size) {
                    try {
                        System.out.println("Producer wait");
                        obj.wait();
                    } catch (InterruptedException e) {

                    }
                }
                queue.offer(i);
                System.out.println(Thread.currentThread().getName() + "生产者生产 " + i + ", 目前总共有 " + queue.size());
                // 生产了元素 可以消费了
                obj.notifyAll();
            }
        }
    }

    static class Consumer {
        public void consumer(int i) {
            synchronized (obj) {
                while (queue.isEmpty()) {
                    try {
                        System.out.println("Consumer wait");
                        obj.wait();
                    } catch (InterruptedException e) {

                    }
                }
                int x = queue.poll();
                System.out.println(Thread.currentThread().getName() + "消费者消费了 " + x + ", 队列中元素 " + queue.size());
                // 生产了元素 可以消费了
                obj.notifyAll();
            }
        }
    }
}


