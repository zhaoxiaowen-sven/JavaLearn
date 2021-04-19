package cp;

public class ObjContainer {

    static final Object obj = new Object();
    static volatile int count = 1;

    public static void main(String[] args) {

        Consumer consumer = new Consumer();
        Producer producer = new Producer();
       Thread threadp = new Thread(new Runnable() {
            @Override
            public void run() {
                 producer.produce();
            }
        });

        Thread threadc = new Thread(new Runnable() {
            @Override
            public void run() {
                consumer.consume();
            }
        });

        threadp.start();
        threadc.start();
    }

    static class Consumer {
        void consume() {
            while (true) {
                synchronized (obj) {
                    while (count <= 0) {
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("consume = " + count);
                    count--;
                    obj.notifyAll();
                }
            }
        }
    }


    static class Producer {
        void produce() {
            while (true) {
                synchronized (obj) {
                    while (count >= 10) {
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println("produce = " + count);
                    obj.notifyAll();
                }
            }
        }
    }
}
