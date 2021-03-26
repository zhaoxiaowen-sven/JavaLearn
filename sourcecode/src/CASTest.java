import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class CASTest {

    private volatile int count = 0;
    private final int size = 1000;

    final AtomicInteger atomicInteger = new AtomicInteger(0);


    public void test () {
        testAtom();
//        casFork();
    }

    private void testAtom() {
        CountDownLatch countDownLatch = new CountDownLatch(size);
        for (int i = 0; i < size; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    atomicInteger.getAndIncrement();
                    countDownLatch.countDown();
                }
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(atomicInteger.get());
    }



    private void casFork() {
        CountDownLatch countDownLatch = new CountDownLatch(size);
        for (int i = 0; i < size; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int i = 0; i < size; i++) {
                        add();
                    }
                    countDownLatch.countDown();
                }


            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.print("count = " + count);
    }


    private synchronized boolean cas(int except, int newCount) {
        if (except == getCount()) {
            count = newCount;
            return true;
        }
        return false;
    }

    private void add() {
        int exceptCount;
        while (!cas(exceptCount = getCount(), exceptCount + 1)) {
        }
    }

    private int getCount() {
        return count;
    }
}
