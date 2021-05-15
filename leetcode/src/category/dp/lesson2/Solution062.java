package category.dp.lesson2;

public class Solution062 {
    public int uniquePaths(int m,int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m ; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[j - 1][i];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] obs = {{0,0,0}, {0,1,0},{0,0,0}};
        new Solution062().uniquePaths(3,2);
    }
}
