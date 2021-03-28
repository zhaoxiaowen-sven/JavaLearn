package aqs;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class AQSTest {

    static final MiniReentrantLock lock = new MiniReentrantLock();
    ReentrantLock reentrantLock = new ReentrantLock();

    public static void test() {
//        testMiniReentrantLock();
        testAcquired();
    }


    public static void testAcquired() {
        boolean failed = true;
        try {
//            for (; ; ) {

                System.out.println("park");
//
            throw new Error("make error");
//                LockSupport.park();
//            }
        } finally {
            System.out.println("finally");
        }
    }

    public static void testMiniReentrantLock() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    sync("thread 1");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                sync("thread 2");
            }
        }).start();
    }

    private static void sync(String s) {
        lock.lock();
        try {
            System.out.println(s);
        } finally {
            lock.unlock();
        }
    }
}
