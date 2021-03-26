package aqs;

public class AQSTest {

    static final MiniReentrantLock lock = new MiniReentrantLock();

    public static void test() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    System.out.println("thread 1");
                } finally {
                    lock.unlock();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    System.out.println("thread 2");
                } finally {
                    lock.unlock();
                }
            }
        }).start();
    }
}
