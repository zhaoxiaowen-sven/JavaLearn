package category.greedy.lesson2;

import java.util.Arrays;

public class Solution1005 {
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int min = Integer.MAX_VALUE;
        int n = A.length;
        int sum = 0;
        // 先排序，并把所有的负数变为正数，同时再遍历过程中记录下最小数，再负数变成正数后取反
        for (int i = 0; i < n; i++) {
            if (A[i] < 0 && K > 0) {
                A[i] = -A[i];
                K--;
            }
            sum += A[i];
            min = Math.min(A[i], min);
        }
        // 把所有的负数旋转后，还是大于0，反复旋转最小的正数，判断翻转了奇数还是偶数次，
        if (K > 0) {
            // 由于不确定min的正负情况，先把min减掉
            sum -= min;
            // 偶数的化相当于没有取反，奇数的化取一次反，k % 2 == 1时
            if (K % 2 == 1) {
                min = -min;
            }
            // 确定正负后再加回来
            return sum + min;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1005().largestSumAfterKNegations(new int[]{4, 2, 3}, 1));
    }
}
