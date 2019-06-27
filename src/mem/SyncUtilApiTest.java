package mem;

import java.util.concurrent.*;

public class SyncUtilApiTest {
    static CyclicBarrier barrier = new CyclicBarrier(2, new A());

    public static void testBarrier() {
        new Thread(() -> {
            try {
                barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(1);

        }).start();

        barrier.reset();

        new Thread(() -> {
            try {
                barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(2);
        }).start();
    }

    static class A implements Runnable {
        @Override
        public void run() {
            System.out.println(3);
        }
    }

    static final int COUNT = 10;
    static ExecutorService e = Executors.newFixedThreadPool(10);
    static Semaphore semaphore = new Semaphore(5);

    public static void testSemaphone() {
        for (int i = 0; i < COUNT; i++) {
            e.execute(new B(i + 1, semaphore));
        }
    }

    static class B implements Runnable {
        int id;
        Semaphore semaphore;

        public B(int id, Semaphore semaphore) {
            this.id = id;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("acquire id = " + id);
                Thread.sleep(500);
                semaphore.release();
                System.out.println("release id = " + id);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
    }

   static Exchanger<String> exchanger = new Exchanger<>();

    public static void testExchanger() {
        e.execute(new C());
        e.execute(new D());
        e.shutdown();
    }

    static class C implements Runnable{

        @Override
        public void run() {
            String A = "银行流水A";
            try {
                exchanger.exchange(A);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
    }

    static class D implements Runnable{
        @Override
        public void run() {
            String B = "银行流水B";
            try {
                String c = exchanger.exchange(B);
                System.out.println("exchange A = " + c +", B = " + B);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
    }
}
