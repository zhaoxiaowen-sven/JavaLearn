package cp;

import java.util.LinkedList;
import java.util.Queue;

public class ObjectContainer {
    private static final Object obj = new Object();
    private static volatile int size = 1;

    public static void main(String[] args) {
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
                    consumer.consumer();
                }
            }
        }).start();

    }

    static class Producer {
        public void produce(int i) {
            while (true) {
                synchronized (obj) {
                    while (size > 10) {
                        try {
                            obj.wait();
                        } catch (Exception e) {

                        }
                    }
                    size ++;
                    System.out.println("producer = " + size);
                    obj.notifyAll();
                }
            }
        }
    }

    static class Consumer {
        public void consumer() {
            while (true) {
                synchronized (obj) {
                    while (size == 0) {
                        try {
                            obj.wait();
                        } catch (Exception e) {

                        }
                    }
                    size --;
                    System.out.println("consume = " + size);
                    obj.notifyAll();
                }
            }
        }
    }
}


