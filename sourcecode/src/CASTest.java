import java.util.concurrent.CountDownLatch;

public class CASTest {

    private volatile int count = 0;
    private final int size = 10;
    public  void test() {

        CountDownLatch countDownLatch = new CountDownLatch(size);
        for (int i = 0 ; i < size ; i++ ) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int i = 0 ; i < size; i ++) {
//                        count ++ ;
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
        int exceptCount ;
        while (!cas(exceptCount = getCount(), exceptCount+1)){
        }
    }

    private int getCount() {
        return count;
    }
}
