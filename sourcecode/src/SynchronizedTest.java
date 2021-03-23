import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

public class SynchronizedTest {
    static volatile int x = 0;

    //打印对应的对象头信息
    static class A {
    }

    static A a ;

    public static void testUpgrade() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        a = new A();

        beforeLock();

        sync();

        afterLock();
    }

    private static void beforeLock() {
        System.out.println("=========beforeLock========");
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
    }


    private static void afterLock() {
        System.out.println("=========afterLock========");
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
    }


    private static void sync() {
        synchronized (a) {
            System.out.println("=========locking========");
            System.out.println(ClassLayout.parseInstance(a).toPrintable());
            x++;
        }
    }

    static final A[] arrays = new A[]{};

    public static void testJOL() {
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
}
