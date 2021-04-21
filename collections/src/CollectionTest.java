import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionTest {
    public static void main(String[] args) {
//
//        Collections.synchronizedList(new ArrayList<>());
//
//
//        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
//        concurrentHashMap.put("x", "y");

        System.out.println("CollectionTest");
//         testIterator();
//        testNormal();
//        testForEach();

//        testLinkedHashMap();

        testHashSet();


        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

    }

    private static void testHashSet() {
        HashSet<String > set = new HashSet<>();
        set.add("a");
        set.add("c");
        set.add("b");

        for (String s : set) {
            System.out.println(s);
        }
    }

    private static void testLinkedHashMap() {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>(10, 0.75f, true);
        linkedHashMap.put("a", " 1");
        linkedHashMap.put("b", " 2");
        linkedHashMap.put("c", " 3");
        for (Map.Entry<String, String> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        for (String key : linkedHashMap.keySet()) {
            System.out.println(linkedHashMap.get(key));
        }
    }

    private static void testNormal() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.remove("b");
            System.out.println(arrayList.get(i));

        }
    }

    private static void testForEach() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        for (String s : arrayList) {
            System.out.println(s);
            arrayList.remove("b");
        }
    }

    private static void testIterator() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            String str = iterator.next();
            if ("b".equals(str)) {
                iterator.remove();
                arrayList.remove("b");
            }
        }
    }
}
