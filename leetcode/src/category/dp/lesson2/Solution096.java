package category.dp.lesson2;

public class Solution096 {
    public int numTrees(int n) {
        // dp[i] ： 1到i为节点组成的二叉搜索树的个数为dp[i]。
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 必须有个头节点
            // 剩余 n-1个节点，左子树的个数就是 d[0] ... d[n-1]
            // 对应的右子树个数是 d[n - 1 -j]
            // 进行排列组合后 就是  dp[i] += dp[j] * dp[i - 1 - j];
            // 初始化我们认为空树 dp[0] =1
            for (int j = 0; j <= i - 1; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        new Solution096().numTrees(3);
    }
}
