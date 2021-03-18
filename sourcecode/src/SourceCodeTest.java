import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SourceCodeTest {

    static class A {
        int a;
    }

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        ConcurrentHashMap<String, String> map2 = new ConcurrentHashMap<>();
        AtomicInteger atomicInteger = new AtomicInteger(1);
        atomicInteger.incrementAndGet();
        new CASTest().test();
        A a = new A();
        //打印JVM的详细信息
        System.out.println(VM.current().details());
        //打印对应的对象头信息
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
    }
}
