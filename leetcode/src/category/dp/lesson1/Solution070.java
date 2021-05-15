package category.dp.lesson1;

public class Solution070 {
    public int climbStairs(int n) {
        // dp[i] 爬到第i楼的方法, i 是楼层
        int[] dp = new int[n + 1];
        //
        dp[0] = 1;

        // i 是可以做的选择
        for (int i = 1; i <= n; i++) {
            // j 是可以做的选择
            for (int j = 1; j <= 2; j++) {
                if (i - j < 0) {
                    continue;
                }
                dp[i] += dp[i - j];
                dump(dp);
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
        new Solution070().climbStairs(4);
    }
}
