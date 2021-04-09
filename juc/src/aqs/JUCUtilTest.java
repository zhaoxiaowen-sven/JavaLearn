package aqs;

import java.util.concurrent.*;

public class JUCUtilTest {


    public static void test() {
//        CountDownlatchTest2();

//        CyclicBarrierTest();

        SemaphoreTest();
    }


    private static void CountDownlatchTest() {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // do sth
                    System.out.println("do sth");
                    countDownLatch.countDown();
                }
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (Exception e) {
        }
    }

    private static void CountDownlatchTest2() {
        CountDownLatch waitLatch = new CountDownLatch(1);
        CountDownLatch signalLatch = new CountDownLatch(2);

        for (int i = 0; i < 2; i++) {
            final int index = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("waitLatch await  i" + index);
                        waitLatch.await();
                        sleep(1000);
                    } catch (InterruptedException e) {
                    } finally {
                        System.out.println("signalLatch countDown " + index);
                        signalLatch.countDown();
                    }
                }
            }).start();
        }
        // 保证子线程先执行
        sleep(500);
        System.out.println("waitLatch countDown ");
        waitLatch.countDown();
        System.out.println("signalLatch await ");
        try {
            signalLatch.await();
        } catch (Exception e) {
        }
    }

    private static void CountDownlatchTest3() {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(new Runnable() {
            @Override
            public void run() {
                // do sth
                System.out.println("do sth");
                countDownLatch.countDown();
            }
        }).start();


        try {
            countDownLatch.await();
        } catch (Exception e) {
        }
    }


    private static void sleep(long millSeconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(millSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void SemaphoreTest() {
        Semaphore semaphore = new Semaphore(2, true);
        int size = 6;
        for (int i = 0; i < size; i++) {
            final int index = i;
           new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println("acquire " + index);
                        Thread.sleep((size - 1) * 100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println("release " + index);
                        semaphore.release();
                    }
                }
            }).start();
        }
    }

    private static void CyclicBarrierTest() {
        int size = 3;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(size);

        final Thread[] thread = new Thread[size - 1];
        for (int i = 0; i < size - 1; i++) {
            final int index = i;
            thread[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("cyclicBarrier access" + index);
                        cyclicBarrier.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }


        for (int i = 0; i < size - 1; i++) {
            thread[i].start();
        }

        sleep(1000);

        try {
            Thread.currentThread().interrupt();
        } catch (Throwable e) {
        }

        try {
            System.out.println("cyclicBarrier access2");
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("cyclicBarrier end");
    }

    private static void CyclicBarrierTest2() {
        int size = 3;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(size);

        final Thread[] thread = new Thread[size - 1];
        for (int i = 0; i < size - 1; i++) {
            final int index = i;
            thread[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("cyclicBarrier access" + index);
                        cyclicBarrier.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        for (int i = 0; i < size - 1; i++) {
            thread[i].start();
        }

        thread[0].interrupt();

//        try {
//            Thread.currentThread().interrupt();
//        } catch (Throwable e) {
//        }

//        try {
//            System.out.println("cyclicBarrier access2");
//            cyclicBarrier.await();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        System.out.println("cyclicBarrier end");
    }
}

