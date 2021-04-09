package bq;

import java.util.concurrent.*;

public class BQTest {

    public static void test() {
        ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();

        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(5);

        LinkedBlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<>();

//        PriorityBlockingQueue
//                DelayQueue
//        LinkedTransferQueue

//        Executors.newScheduledThreadPool()


        testSynchronousQueue();

//        testLinedTransferQueue();

//        DelayQueue<String> delayQueue = DelayQueue<>(5);
//        LinkedBlockingDeque
        //                LinkedBlockingDeque
    }

    private static void testSynchronousQueue() {
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>(false);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String t = synchronousQueue.take();
                    System.out.println("take = " + t);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("put ");
                    synchronousQueue.put("x");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("put ");
                    synchronousQueue.put("x");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private static void testLinedTransferQueue() {
        LinkedTransferQueue<String> transferQueue = new LinkedTransferQueue<>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String t = transferQueue.take();
                    System.out.println("take = " + t);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
//                try {
                System.out.println("put before = ");
                transferQueue.put("y");
                System.out.println("put after ");

//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
//                try {
                System.out.println("put before = ");
                transferQueue.put("x");
                System.out.println("put after ");

//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }).start();
    }

}
