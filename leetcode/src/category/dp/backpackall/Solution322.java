package category.dp.backpackall;

import category.dp.backpack01.DpUtils;

import java.util.Arrays;

public class Solution322 {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        // dp 数组的定义：当目标金额为 j 时，至少需要 dp[i][j] 枚硬币凑出。
        int[][] dp = new int[n + 1][amount + 1];

        for (int j = 0; j <= amount; j++) {
            dp[0][j] = amount + 1;
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = amount; j >= 1; j--) {
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - coins[i - 1]] + 1);
                }
            }
            DpUtils.dump(dp);
        }
        return dp[n][amount] == amount + 1 ? -1 : dp[n][amount];
    }

    public int coinChange2(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        //
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] >= 0) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i - 1]] + 1);
                }
            }
            DpUtils.dump(dp);
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(new Solution322().coinChange(coins, 5));
        System.out.println(new Solution322().coinChange2(coins, 5));
    }
}