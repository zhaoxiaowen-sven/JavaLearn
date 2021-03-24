import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import java.util.concurrent.CountDownLatch;

public class SynchronizedTest {
    static volatile int x = 0;

    //打印对应的对象头信息
    static class A {
    }

    static A a = new A();

    public static void test() {
//        noLock();
//        biasLock();
        lightLock();
//        heavyLock();
    }

    private static void noLock() {
        a = new A();
        beforeLock();
        sync();
        afterLock();
    }

    private static void biasLock() {
        // sleep偏向锁延迟=0
        sleep(5000);
        a = new A();
        beforeLock();
        sync();
        afterLock();
    }

    public static void lightLock() {
        // 是否偏向延迟会有2种结果，解释https://blog.csdn.net/qq_36434742/article/details/106876862
        sleep(5000);
        a = new A();
        beforeLock();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                sync("thread1");
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                sync("thread2");
            }
        });
        thread1.start();
        join(thread1);
        thread2.start();
        join(thread2);
        afterLock();
    }

    private static void heavyLock() {
        sleep(5000);
        a = new A();
        beforeLock();
        int threadSize = 2;
        CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        for (int i = 0; i < threadSize; i++) {
            final int id = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    sync("thread_" + id);
                    countDownLatch.countDown();
                }
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        afterLock();
    }

    public static void testJOL() {
        a = new A();
        A[] arrays = new A[]{};

        //打印JVM的详细信息
        System.out.println(VM.current().details());

        //1.打印普通对象内存布局
        System.out.println("=========普通对象内存布局========");
        System.out.println(ClassLayout.parseInstance(a).toPrintable());

        //2.打印数组对象内存布局
        System.out.println("=========数组对象内存布局========");
        System.out.println(ClassLayout.parseInstance(arrays).toPrintable());
        //3.打印class对象内存布局
        System.out.println("=========class对象内存布局========");
        System.out.println(ClassLayout.parseInstance(SynchronizedTest.class).toPrintable());
    }

    private static void beforeLock() {
        System.out.println("=========beforeLock========");
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
    }

    private static void afterLock() {
        System.out.println("=========afterLock========");
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
    }

    private static void sync(String thread) {
        synchronized (a) {
            System.out.println(thread + "=========locking========");
            System.out.println(ClassLayout.parseInstance(a).toPrintable());
            x++;
        }
    }

    private static void join(Thread thread) {
        try {
            thread.join();
        } catch (Exception e) {

        }
    }

    private static void sync() {
        synchronized (a) {
            System.out.println("=========locking========");
            System.out.println(ClassLayout.parseInstance(a).toPrintable());
            x++;
        }
    }

    private static void sleep(long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
