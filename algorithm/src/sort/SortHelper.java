package sort;

public class SortHelper {

    public static void dump(int[] source) {
        StringBuilder builder = new StringBuilder();
        for (int element : source) {
            builder.append(element).append(", ");
        }
        System.out.println(builder.toString());
    }
}
