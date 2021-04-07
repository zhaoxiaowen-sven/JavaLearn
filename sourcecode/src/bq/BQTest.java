package bq;

import java.util.concurrent.*;

public class BQTest {

    public static void test() {
        ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();

        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(5);

        LinkedBlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<>();

//        PriorityBlockingQueue
//                DelayQueue
    }
}
