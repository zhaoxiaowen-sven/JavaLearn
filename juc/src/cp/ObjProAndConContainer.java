package cp;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ObjProAndConContainer {

    public static void main(String[] args) {
        new ObjProAndConContainer().start();
    }

    public void start() {
        Buffer buffer = new Buffer();
        new Thread(new Producer(buffer), "produce ").start();
        for (int i = 0; i < 3; i++) {
            new Thread(new Consumer(buffer), "consume" + i).start();
        }
    }

    // 1、生产者
    class Producer implements Runnable {
        Buffer buffer;

        public Producer(Buffer buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            // 死循环，不停从向队列中放元素
            while (true) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 元素是随机数
                buffer.put(new Random().nextInt());
            }
        }
    }

    // 2、消费者
    class Consumer implements Runnable {
        Buffer buffer;

        public Consumer(Buffer buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 死循环，不停从队列中取元素
                buffer.get();
            }
        }
    }

    // 缓冲区
    class Buffer {
        final int size = 100;
        // 双向队列实现，锁对象也是缓冲队列
        final Queue<Integer> queue = new LinkedList<>();

        void put(int i) {
            synchronized (queue) {
                // 在使用线程的等待通知机制时，一般都要在 while 循环中调用 wait() 方法。
                // 因为唤醒的瞬间有可能其他的生产者线程先拿到了锁进行了生产，
                // 所以队列又经历了一个从不满到满的过程。
                while (queue.size() == size) {
                    try {
                        queue.wait(); // 阻塞
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "生产者生产 = " + i);
                queue.offer(i);
                queue.notifyAll(); // 唤醒所有的，包括生产者和消费者
            }
        }

        void get() {
            synchronized (queue) {
                while (queue.size() == 0) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int val = queue.poll();
                System.out.println(Thread.currentThread().getName() + " 消费者消费 = " + val);
                queue.notifyAll(); // 唤醒所有的，包括生产者和消费者
            }
        }
    }
}
