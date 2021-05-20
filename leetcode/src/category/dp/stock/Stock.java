package category.dp.stock;

import category.dp.backpack01.DpUtils;

public class Stock {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                dp[i][0] = 0;
                // 解释：
                //   dp[i][0]
                // = max(dp[-1][0], dp[-1][1] + prices[i])
                // = max(0, -infinity + prices[i]) = 0
                dp[i][1] = -prices[i];
                //解释：
                //   dp[i][1]
                // = max(dp[-1][1], dp[-1][0] - prices[i])
                // = max(-infinity, 0 - prices[i])
                // = -prices[i]
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        DpUtils.dump(dp);

        return dp[n - 1][0];
//        int[][] dp = new int[n + 1][2];
//        // dp [0][0] = 0;
//        // dp [0][1] = -infanity
//        dp[0][0] = 0;
//        dp[0][1] = Integer.MIN_VALUE;
//        for (int i = 1; i <= n; i++) {
//            // 0，不持有
//            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
//            dp[i][1] = Math.max(dp[i - 1][1], - prices[i - 1]);
//        }
//        DpUtils.dump(dp);
//        return dp[n][0];
    }

    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            // dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            // dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;
    }

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][k + 1][2];
        // bad case
        dp[0][0][0] = 0;
        dp[0][0][1] = Integer.MIN_VALUE;
//
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];

        // dp[0][j][0] 都均为0
        // dp[0][j][1] 异常值都取Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < n; i++) {
            for (int ki = k; ki >= 1; ki--) {
                if (i-1 == -1) {
                    dp[0][ki][0] = 0;
                    dp[0][k][1] = Integer.MIN_VALUE;
                    continue;
                }
                //
                dp[i][ki][0] = Math.max(dp[i - 1][ki][0], dp[i - 1][ki][1] + prices[i]);
                dp[i][ki][1] = Math.max(dp[i - 1][ki][1], dp[i - 1][ki - 1][0] - prices[i]);
            }
        }
//        // 穷举了 n × max_k × 2 个状态，正确。
        return dp[n - 1][k][0];
//        int res = 0;
//        for (int i = 1; i < k + 1; i++) {
//            res = Math.max(res, dp[prices.length - 1][i][0]);
//        }

//        return res;
    }

    public static void main(String[] args) {
        // int[] prices = {7, 1, 5, 3, 6, 4};
        //new Stock().maxProfit(prices);
        int[] prices2 = {2, 4, 1};
        System.out.println(new Stock().maxProfit(2, prices2));
    }
}
