package category.dp.backpack;

import category.dp.lesson2.Solution096;

public class Solution {

    private int backpack(int n, int w, int[] val, int[] weight) {
        // dp[i][w] , 重量为w的i件物品的最大价值
        int[][] dp = new int[n + 1][w + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (w - weight[i - 1]  < 0) {
                    dp[i][j] = dp[i - 1][j];//
                } else {
                    dp[i][j] = Math.max(
                            dp[i - 1][j], //
                            val[i - 1] + dp[i - 1][w - weight[i - 1]]//
                    );
                }
            }
        }
        return dp[n][w];
    }

    public static void main(String[] args) {
        int n = 3;
        int w = 4;
        int[] val = {15,20,30};
        int[] weight = {1,3,4};
        System.out.println(new Solution().backpack(n, w, val ,weight));
    }
}
