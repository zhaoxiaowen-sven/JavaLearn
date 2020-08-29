package sort;

public class HeapSort {

    public static void sort0(int[] source) {

        int n = source.length;
        // 建堆，从中间节点开始，中间节点必有子节点
        // 建堆的过程先自下而上，在自上而下
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(source, n, i);
        }
        // 排序
        for (int j = n - 1; j > 0; j--) {
            swap(source, j, 0);
            heapify(source, j, 0);
        }
        SortHelper.dump(source);
    }

    /**
     * 维护堆的算法
     *
     * @param source
     * @param n      数组长度
     * @param i      待维护节点下标
     */
    private static void heapify(int[] source, int n, int i) {
        // large 表示当前最大值
        int large = i;
        int leftSon = i * 2 + 1;
        int rightSon = i * 2 + 2;

        if (leftSon < n && source[leftSon] > source[large]) {
            large = leftSon;
        }

        if (rightSon < n && source[rightSon] > source[large]) {
            large = rightSon;
        }
        // 若父节点小于左节点或者小于右节点，那么就要交换父子节点的值，
        // 交换完毕后，还需要对新的子节点进行维护
        if (large != i) {
            swap(source, i, large);
            // large 指向的是被交换子节点的索引
            heapify(source, n, large);
        }
    }

    private static void swap(int[] source, int left, int right) {
        int temp = source[left];
        source[left] = source[right];
        source[right] = temp;
    }
}
