package category.dp;

public class Solution070 {
    public int climbStairs(int n) {
        // dp[i]  爬到第i楼的方式, i 是楼层
        int[] dp = new int[n + 1];
        // 初始化值是0，这是一个求最大的题，所以初始值是最小
        // Arrays.fill(dp, );

        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= 2; j++) {
                if (i - j < 0) {
                    continue;
                }
                dump(dp);
                dp[i] = Math.max(dp[i], dp[i - j] + 1);
            }
        }
        return dp[n];
    }

    private void dump(int[] dp) {
        StringBuilder builder = new StringBuilder();
        for (int i :dp) {
            builder.append(i).append(",");
        }
        System.out.println(builder.toString());
    }

    public static void main(String[] args) {
        new Solution070().climbStairs(6);
    }
}
