package category.dp;

public class Solution509 {
    public int fib(int n) {
//        if (n == 0 || n == 1) {
//            return n;
//        }
//        return fib(n - 1) + fib(n - 2);

        // 解法二：增加备忘录
//        int[] memo = new int[n + 1];
//        return helper(memo, n);

        // n + 1
        // 第i个数的斐波那契数值是dp[i], n的值是 dp[n],所有数组大小是n + 1
//        int[] dp = new int[n + 1];
//        dp[0] = 0;
//        dp[1] = 1;
//        for (int i = 2; i <= n; i++) {
//            dp[i] = dp[i - 1] + dp[i - 2];
//        }
//        return dp[n];

        if (n <= 1) {
            return n;
        }
        // 继续优化空间复杂度
        int cur = 1;
        int pre = 0;
        for (int i = 2; i <= n; i++) {
            int sum = pre + cur;
            pre = cur;
            cur = sum;
        }
        return cur;

    }

    private int helper(int[] memo, int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = fib(memo[n - 1]) + fib(memo[n - 2]);
        return memo[n];
    }


    public static void main(String[] args) {
        new Solution509().fib(2);
        System.out.println(9149 & 1<<13);
    }
}
