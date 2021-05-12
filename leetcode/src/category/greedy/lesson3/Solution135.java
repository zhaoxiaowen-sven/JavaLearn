package category.greedy.lesson3;

import java.util.Arrays;

public class Solution135 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candys = new int[n];
        Arrays.fill(candys, 1);
        // 从左向右, ratings[i] > ratings[i - 1]
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candys[i] = candys[i - 1] + 1;
            }
        }
        // 从右向左, ratings[i] > ratings[i + 1]
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) { // 左边权值小于右边
                if (candys[i] <= candys[i + 1]) { // 左边的糖数小于右边
                    candys[i] = candys[i + 1] + 1;
                }
                //  candys[i] = Math.max(candys[i], candys[i + 1] + 1);
            }
        }

        int count = 0;
        for (int i : candys) {
            count += i;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution135().candy(new int[]{1, 3, 2, 2, 1}));
    }
}
