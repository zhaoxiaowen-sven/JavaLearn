package cp;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ConsumerAndProducer {

    public static void main(String[] args) {
        new ConsumerAndProducer().start();
    }

    public void start() {
        Buffer buffer = new Buffer();
        new Thread(new Producer(buffer), "produce ").start();
        for (int i = 0; i < 3; i++) {
            new Thread(new Consumer(buffer), "consume" + i).start();
        }
    }

    class Producer implements Runnable {
        Buffer buffer;

        public Producer(Buffer buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                buffer.put(new Random().nextInt());
            }
        }
    }

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
                buffer.get();
            }
        }
    }

    class Buffer {
        final int size = 100;
        Queue<Integer> queue = new LinkedList<>();

        void put(int i) {
            synchronized (queue) { // 得用同一把锁唤醒
                while (queue.size() >= size) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " put = " + i);
                queue.offer(i);
                queue.notifyAll();
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
                System.out.println(Thread.currentThread().getName() + " get = " + val);
                queue.notifyAll();
            }
        }
    }
}
