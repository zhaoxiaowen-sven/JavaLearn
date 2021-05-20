package category.dp.backpackall;

import category.dp.backpack01.DpUtils;

import java.util.Arrays;

public class Solution322 {

    // FIXME: 2021/5/20 有问题的思考下？？？
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

    public int coinChange3(int[] coins, int amount) {
//        if (amount <= 0) {
//            return -1;
//        }
//
//        int res = Integer.MAX_VALUE;
//        for (int coin : coins) {
//            int subProblem = coinChange(coins, amount - coin);
//            if (subProblem < -1) {
//                continue;
//            }
        // 子问题中的最优解
//            res = Math.min(res, subProblem);
//        }
//
//        return res == Integer.MAX_VALUE ? -1 : res;

        // 解法2：
//        int[] memo = new int[amount + 1];
//        Arrays.fill(memo, -100);
//        return coinChange(coins, amount, memo);

        return dp(coins, amount);
    }

    private int coinChange4(int[] coins, int amount, int[] memo) {
        // amount == 0 时需要 0个硬币
        if (amount == 0) {
            return 0;
        }
        // amount < 0 时，不可能凑到
        if (amount < 0) {
            return -1;
        }
        if (memo[amount] != -100) {
            return memo[amount];
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subRes = coinChange4(coins, amount - coin, memo);
            if (subRes == -1) {
                continue;
            }
            res = Math.min(res, subRes + 1);
        }
        return memo[amount] = res == Integer.MAX_VALUE ? -1 : res;
    }

    // 凑出amount 至少需要dp[amount]个硬币
    private int dp(int[] coins, int amount) {
        // 索引范围 [0, amount]
        // dp数组定义：凑出i，至少需要硬币数dp[i]
        int[] dp = new int[amount + 1];
        // 出初始化为 amount + 1
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        // 遍历状态的所有取值， 从硬币 0 -> amount
        for (int i = 0; i <= amount; i++) {
            // 内层for循环求所有选择的最小值
            for (int coin : coins) {
                // 凑到i，需要的coin 无解，跳过
                if (i - coin < 0) {
                    continue;
                }
                // 在dp[i - coin] 基础上多了一枚硬币 +1
                // d[i] 可能有多个最小值，找最小值
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                DpUtils.dump(dp);
            }
        }
//        dump(dp);

        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(new Solution322().coinChange(coins, 5));
        System.out.println(new Solution322().coinChange2(coins, 5));
    }
}