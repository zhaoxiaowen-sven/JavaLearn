import aqs.AQSTest;
import bq.BQTest;
import cp.Container;
import cp.QueueContainer;

public class JUCTest {

    public static void main(String[] args) {

//        new CASTest().test();
//        VolatileTest.getInstance();
//        SynchronizedTest.test();
        try {
            AQSTest.test();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        Container.test();
//        new ConditionTest().test();

//        BQTest.test();
//        QueueContainer.test();
    }
}
