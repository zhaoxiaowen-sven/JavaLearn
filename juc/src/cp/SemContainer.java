package cp;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class SemContainer {

    Semaphore fullCount = new Semaphore(0);
    Semaphore emptyCount = new Semaphore(10);
    Semaphore isUse = new Semaphore(1);

    List queue = new LinkedList<Integer>();

    public static void main(String[] args) {

        SemContainer container = new SemContainer();

        new Thread(new Producer(container)).start();

        new Thread(new Consumer(container)).start();
        new Thread(new Consumer(container)).start();
    }


    public void put(Integer val) {
        try {
            // 1、资源量 empty > 0才put
            emptyCount.acquire();
            // 2、锁的作用
            isUse.acquire();

            System.out.println(Thread.currentThread().getName() + "生产者生产 = " + val);
            queue.add(val);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 1、
            isUse.release();
            // 2、
            fullCount.release();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Integer get() {
        Integer val1 = 0;
        try {
            // 1、资源量 >0 才能获取
            fullCount.acquire();
            isUse.acquire();

            val1 = (Integer) queue.remove(0);
            System.out.println(Thread.currentThread().getName() + " 消费者消费 = " + val1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            isUse.release();
            emptyCount.release();
        }
        return val1;
    }
}

class Consumer implements Runnable {
    private SemContainer container;

    public Consumer(SemContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        while (true) {
            Integer val = container.get();
        }
    }
}

class Producer implements Runnable {
    private SemContainer container;

    public Producer(SemContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        while (true) {
            container.put(new Random().nextInt(100));
        }
    }
}