package category.dp.subseq2;

public class Solution072 {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int j = 1; j <= word1.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }

        // word1 变成 word2 对应的是 i j
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(
                            dp[i][j - 1] + 1, // 插入
                            Math.min(dp[i - 1][j] + 1, // 删除
                                    dp[i - 1][j - 1] + 1// 替换
                            ));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
