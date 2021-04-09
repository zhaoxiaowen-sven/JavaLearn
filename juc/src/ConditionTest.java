
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void test() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();

                try {
//            Thread.sleep(1000);
                    long nanos = condition.awaitNanos(1000 * 1000);

                    System.out.println("nanos = " + nanos);
                } catch (InterruptedException e) {

                } finally{
                    lock.lock();
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                conditionSignal();
            }
        }).start();

        // 等待
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                conditionWait();
//            }
//        }).start();
//
//        // 唤醒
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                conditionSignal();
//            }
//        }).start();
    }

    private void conditionWait() {
        //
        lock.lock();
        try {
            try {
                System.out.println("conditionWait");
                condition.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            System.out.println("await finally");
            lock.unlock();
        }
    }

    private void conditionSignal() {
        lock.lock();
        try {
            System.out.println("conditionSignal");
            condition.signal();
        } finally {
            System.out.println("signal finally");
            lock.unlock();
        }
    }
}
