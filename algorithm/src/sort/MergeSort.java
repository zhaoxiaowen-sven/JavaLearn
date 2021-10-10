package sort;

public class MergeSort {

    public static void sort0(int[] source) {
        sort(source, 0, source.length - 1);
        SortHelper.dump(source);
    }

    private static void sort(int[] source, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            sort(source, left, center);
            sort(source, center + 1, right);
            merge(source, left, center, right);
        }
    }
    private static void merge(int[] source, int left, int center, int right) {
        int[] tmp = new int[right - left + 1];
        int k = 0; int i = left; int j = center + 1;
        // 从小到大排，取较小值放到tmp数组里
        while (i <= center && j <= right) {
            if (source[i] < source[j]) {
                tmp[k++] = source[i++];
            } else {
                tmp[k++] = source[j++];
            }
        }
        // 多的元素放到末尾
        while (i <= center) {
            tmp[k++] = source[i++];
        }
        // 多的元素放到末尾
        while (j <= right) {
            tmp[k++] = source[j++];
        }
        // 将排序好的数组替换原数组相同位置
        for (int i1 = 0; i1 < tmp.length; i1++) {
            source[left + i1] = tmp[i1];
        }
    }
}
