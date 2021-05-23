package category.dp.lesson2;

import category.dp.backpack01.DpUtils;

public class Solution064 {

    public int minPathSum(int[][] grid) {
        int n = grid[0].length;
        int m = grid.length;
        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        // dp[0][j] = 0;
        // dp[j][0] = 0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        //DpUtils.dump(dp);
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] nums = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        int[][] nums2 = {
                {1, 2, 3},
                {4, 5, 6},
        };

        System.out.println(new Solution064().minPathSum(nums2));
    }
}
