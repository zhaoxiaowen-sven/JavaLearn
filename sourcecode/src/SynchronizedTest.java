//import org.openjdk.jol.info.ClassLayout;
//import org.openjdk.jol.vm.VM;

public class SynchronizedTest {
    static int i = 0;
    public static void test() {
        synchronized (SynchronizedTest.class) {
            i ++;
        }
    }

//    private synchronized void method() {
//
//    }

    //        A a = new A();
//        //打印JVM的详细信息
//        System.out.println(VM.current().details());
//        //打印对应的对象头信息
//        System.out.println(ClassLayout.parseInstance(SynchronizedTest.class).toPrintable());
//    static class A {

//    }
}
