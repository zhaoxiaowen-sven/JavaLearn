import com.sun.xml.internal.bind.v2.model.annotation.RuntimeAnnotationReader;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

public class SynchronizedTest {
    static volatile int x = 0;

    //打印对应的对象头信息
    static class A {
    }

    static A a ;

    public static void testBiasLock() {

        // 偏向锁初始化
//        sleep(5000);

        a = new A();

        beforeLock();

        sync();

        afterLock();
    }

    private static void sleep(long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void biasLock() {

    }

    public static void lightLock() {
        a = new A();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
//                sleep(3000);
                sync("thread1");
            }
        });
        thread1.start();
        join(thread1);
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                sync("thread2");
            }
        });

        thread2.start();
//        join(thread2);
//        sync();
    }

    private static void heavyLock() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
//                sleep(3000);
                sync();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                sync();
            }
        });

        thread1.start();
        thread2.start();
    }


    private static void beforeLock() {
        System.out.println("=========beforeLock========");
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
    }


    private static void afterLock() {
        System.out.println("=========afterLock========");
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
    }


    private static void sync(String s) {
        synchronized (a) {
            System.out.println("=========locking========" + s);
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
