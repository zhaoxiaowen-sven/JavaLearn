package aqs;

import sun.java2d.loops.GraphicsPrimitive;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class AQSTest {

    static final MiniReentrantLock lock = new MiniReentrantLock();
    final static ReentrantLock reentrantLock = new ReentrantLock(true);
    static volatile long start = 0;

    public static void test() throws InterruptedException {
        //        testMiniReentrantLock();
//        testAcquired();
//        Thread.currentThread().interrupt();
//        Thread.interrupted()

//       Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                testInterrupt("thread1");
//            }
//        });
//
//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                testInterrupt("thread2");
//            }
//        });
//
//        thread1.start();
//        thread2.start();
//        System.out.println("中断了");
//
//        JUCUtilTest.test();
        start = System.currentTimeMillis();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
//                testInterrupt2();
                LockSupport.park();
                System.out.println("parkstart " + (System.currentTimeMillis() - start));
            }
        }, "t1");

        thread1.start();
        Thread.sleep(2000);
        thread1.interrupt();

//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                testInterrupt2();
//            }
//        }, "t2");
//
//        System.out.println("111");
//        thread2.start();
//        Thread.sleep(1000);

//        System.out.println("222");
//        thread2.interrupt();
//        System.out.println("333");
    }

    private static void testReadWriteLock() {
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

        readLock.lock();
        readLock.unlock();

        writeLock.lock();
        writeLock.unlock();


    }

    public static void testInterrupt2() {
        String tName = Thread.currentThread().getName();
        try {
            System.out.println("run " + tName + ", " + (System.currentTimeMillis() - start));
            reentrantLock.lockInterruptibly();
            System.out.println("running " + tName + ", " + (System.currentTimeMillis() - start));
            String s = "a";
            for (int i = 0; i < 100 * 1000; i ++) {
                s+="a";
            }
            System.out.println("run end " + tName + ", "+ (System.currentTimeMillis() - start));
        } catch (Exception e) {
//            System.out.println( );
            e.printStackTrace();

        } finally {
            reentrantLock.unlock();
        }
    }


    public static void testInterrupt(String sleep) {

        try {
            //                System.out.println("park after");

            reentrantLock.lock();
//            reentrantLock.lock();
//            System.out.println("before park" );
//            LockSupport.park();
//            System.out.println("park after");
            int a = 1;
            System.out.println("执行");

            for (int i = 0; i< Integer.MAX_VALUE/1000 - 1 ; i++) {
                        a = a *100;
            }
//            if (sleep > 0) {
//                System.out.println("before park" );
//                LockSupport.park();
//                System.out.println("park after");
//            }
        }
//        catch (InterruptedException e) {
//            System.out.println("InterruptedException" + sleep + e);
//        }
        finally {
            System.out.println("unlock");
            reentrantLock.unlock();
        }
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
