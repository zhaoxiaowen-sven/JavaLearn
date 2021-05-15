package category.dp.lesson2;

public class Solution343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        // dp[i] 代表 i 的最大乘积
        // 状态的所用取值
        dp[2] = 1;
        for (int i = 2; i <= n; i++) {
            // 做选择
            for (int j = 1; j < i; j++) {
                // 求最值, dp[i]=Math.max((i - j) * j, dp[i - j] * j)
                // 同时 dp[i] 是不断更新的的，所以
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution343().integerBreak(8));
    }
}
