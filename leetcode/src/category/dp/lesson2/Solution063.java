package category.dp.lesson2;

public class Solution063 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < n && obstacleGrid[j][0] == 0; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) { // 障碍的地方置为0
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[j - 1][i];
            }
        }
        return dp[n - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] obs = {{0,0,0}, {0,1,0},{0,0,0}};
        new Solution063().uniquePathsWithObstacles(obs);
    }
}
