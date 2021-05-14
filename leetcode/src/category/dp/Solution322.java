package category.dp;

import java.util.Arrays;

public class Solution322 {
    public int coinChange(int[] coins, int amount) {
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

    private int coinChange(int[] coins, int amount, int[] memo) {
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
            int subRes = coinChange(coins, amount - coin, memo);
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
                dump(dp);
            }
        }
//        dump(dp);

        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

    private void dump(int[] dp) {
        StringBuilder builder = new StringBuilder();
        for (int i :dp) {
            builder.append(i).append(",");
        }
        System.out.println(builder.toString());
    }

    public static void main(String[] args) {
        int[] coins = new int[]{2, 5};
        new Solution322().dp(coins, 3);
    }
}
