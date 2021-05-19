package category.dp.backpackall;

public class Solution070II {
    // 改为：一步一个台阶，两个台阶，三个台阶，.......，直到 m个台阶。问有多少种不同的方法可以爬到楼顶呢？
    //
    //1阶，2阶，.... m阶就是物品，楼顶就是背包。
    public int climbStairs(int n, int m) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        // 排列问题
        for (int j = 1; j <= n; j++) {//遍历背包
            for (int i = j; i <= m; i++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - i];
            }
        }
        return dp[n][m];
    }

    public int climbStairs2(int n, int m) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        // 排列问题
        for (int j = 1; j <= n; j++) {//遍历背包
            for (int i = j; i <= m; i++) {
                dp[j] = dp[j] + dp[j - i];
            }
        }
        return dp[n];
    }
}
