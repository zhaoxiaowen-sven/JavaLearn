package category.dp.backpack;

public class Solution1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int i : stones) {
            sum += i;
        }
        int target = sum / 2;
        // dp[i][j]
        // 前i个数的，在j的限制下的最大值
        int[][] dp = new int[stones.length + 1][target + 1];

        for (int i = 1; i <= stones.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j < stones[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                }
            }
        }

        return sum - dp[stones.length][target] * 2;
    }

    public int lastStoneWeightII2(int[] stones) {
        int sum = 0;
        for (int i : stones) {
            sum += i;
        }
        int target = sum / 2;
        // dp[j]
        // 前i个数的，在j的限制下的最大值
        int[] dp = new int[target + 1];

        for (int stone : stones) {
            for (int j = target; j >= stone; j--) {
                dp[j] = Math.max(dp[j - 1], dp[j - stone] + stone);
            }
        }

        return sum - dp[target] * 2;
    }
}
