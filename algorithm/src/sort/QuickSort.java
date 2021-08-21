package sort;

public class QuickSort {

    public static void main(String[] args) {

        int[] arr = new int[]{9, 1, 5, 8, 3, 7, 4, 6, 2};
        sort0(arr);
    }


    public static void sort0(int[] source) {
        sort(source, 0, source.length - 1);
        SortHelper.dump(source);
    }

    private static void sort(int[] source, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(source, left, right);
        SortHelper.dump(source);
        sort(source, left, pivot - 1);
        sort(source, pivot + 1, right);
    }

    private static int partition(int[] source, int left, int right) {
        int pivot = source[left];
        // 从两端同时向中间遍历，将较小的数放到左边，较大的数放到右边
        while (left < right) {
            if (source[left] < pivot) {
                left ++;
            }
            if (source[right] > pivot) {
                right --;
            }
            // 左右查找到不合规则的数据时，进行交换
            swap(source,left, right);
        }
        // 当left >= right时说明，左右的数均已划分好了
        source[left] = pivot;
        return left;
    }

    private static void swap(int[] source, int left, int right) {
        int temp = source[left];
        source[left] = source[right];
        source[right] = temp;
    }

    // 优化中间值取值
    private static void getPivot(int[] source, int left, int right) {
        int m = (left + right) / 2;
        // 比较左右的大小，保证左边小于右边
        if (source[left] > source[right]) {
            swap(source, left, right);
        }

        // 比较中间和右边的顺序，保证中间小于右边
        if (source[m] > source[right]) {
            swap(source, right, m);
        }
        // 比较左边和中间的顺序，保证left存放中间值
        if (source[m] > source[left]) {
            swap(source, left, m);
        }
    }




}
