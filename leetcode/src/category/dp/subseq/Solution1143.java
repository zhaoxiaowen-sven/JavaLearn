package category.dp.subseq;

public class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        // 初始化，其实没必要
        for (int i = 0; i <= text1.length(); i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= text2.length(); j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 不同时 取 text1[i - 1] + text2[j] 和 text1[i] + text2[j - 1] 中较小的值，
                    // 所以dp[i][j] 一定为最大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
//        new Solution1143().longestCommonSubsequence("abcde", "ace");
        new Solution1143().longestCommonSubsequence("bl", "yby");
    }
}
