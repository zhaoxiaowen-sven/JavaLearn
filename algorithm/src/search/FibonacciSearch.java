package search;

public class FibonacciSearch {

    public static final int[] F = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34};

    public static int search(int[] arr, int key) {
        int find = -1;
        int low = 0;
        int high = arr.length - 1;
        int mid;
        int k = 0;
        // 计算n位于斐波那契数列的位置
        while (arr.length > F[k]) {
            k++;
        }
        int[] temp = new int[F[k]];
        // 将数列补充为斐波那契的长度F[k]，不足的位数取值为数组最后一位的值。
        for (int i = 0; i < F[k]; i++) {
            if (i < arr.length) {
                temp[i] = arr[i];
            } else {
                temp[i] = arr[high];
            }
        }
        // F[k] = F[k-1] + F[k-2]
        while (low <= high) {
            mid = low + F[k - 1] - 1;
            if (key < temp[mid]) {
                // 当关键字小于中间值时，取前边的序列，high从mid -1开始，长度为F[k-1]，所以k-=1
                high = mid - 1;
                k -= 1;
            } else if (key > temp[mid]) {
                // 当关键字大于中间值时，取后边的序列，low要从mid+1开始，长度为F[k-2]，所以k-=2
                low = mid + 1;
                k -= 2;
            } else {
                find = mid;
                break;
            }
        }
        if (find < arr.length) {
            System.out.println("find = " + find + " , k = " + k);
        } else {
            System.out.println("find out of arr " + find + " , k = " + k);
        }
        return find;
    }
}
