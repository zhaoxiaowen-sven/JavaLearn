import java.awt.*;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SourceCodeTest {
    public synchronized static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        ConcurrentHashMap<String, String> map2 = new ConcurrentHashMap<>();
        AtomicInteger atomicInteger = new AtomicInteger(1);
        atomicInteger.incrementAndGet();
        new CASTest().test();
    }
}
