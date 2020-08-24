package sort;

public class SelectSort {

    public static void sort0(int[] source) {
        int len = source == null ? 0 : source.length;
        if (len == 0 || len == 1) {
            System.out.println("element less 1");
            return;
        }

        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (source[minIndex] > source[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = source[minIndex];
                source[minIndex] = source[i];
                source[i] = temp;
            }
            SortHelper.dump(source);
        }
        SortHelper.dump(source);
    }
}
