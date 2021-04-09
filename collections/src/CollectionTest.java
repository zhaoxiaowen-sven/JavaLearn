import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

public class CollectionTest {
    public static void main(String[] args) {

        Collections.synchronizedList(new ArrayList<>());


        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("x", "y");

    }
}
