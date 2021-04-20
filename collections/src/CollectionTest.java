import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

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
        testNormal();
        testForEach();

        LinkedList<String> list = new LinkedList<>();
        HashSet<String> set = new HashSet<>();


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
