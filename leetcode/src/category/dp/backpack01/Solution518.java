package category.dp.backpack01;

public class Solution518 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        // dp 凑成 j 的 前i个数的组合数目
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) { // !! 注意 这里是 <=
            for (int j = 1; j <= amount; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
                //   DpUtils.dump(dp);
            }
        }
        return dp[n][amount];
    }

    public int change2(int amount, int[] coins) {
        int n = coins.length;
        // dp[j] 的组合
        int[] dp = new int[amount + 1];
        // 从dp[i]的含义上来讲就是，凑成总金额0的货币组合数为1。
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = coins[i - 1]; j <= amount; j++) {
                dp[j] = dp[j] + dp[j - coins[i - 1]];
                // DpUtils.dump(dp);
            }
        }
        return dp[amount];
    }

    int res = 0;

    // 递归解法
    public int change3(int amount, int[] coins) {
        if (coins.length == 0) {
            return 0;
        }
        dfs(coins, amount, 0);
        return res;
    }

    private void dfs(int[] coins, int amount, int startIndex) {
        if (amount < 0) {
            return;
        }

        if (amount == 0) {
            res++;
            return;
        }

        for (int i = startIndex; i < coins.length; i++) {
            dfs(coins, amount - coins[i], i);
        }
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};

        System.out.println(new Solution518().change(5, coins));
        System.out.println(new Solution518().change2(5, coins));
        System.out.println(new Solution518().change3(5, coins));
    }
}
