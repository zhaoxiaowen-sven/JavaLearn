package category.dp.subseq2;

public class Solution392 {
    public boolean isSubsequence(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 相当于看前面字符的匹配了多少个
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[s.length()][t.length()] == s.length();

//        if (s.length() == 0) {
//            return true;
//        }
//        int i = 0;
//        int j = 0;
//        while (i < t.length() && j < s.length()) {
//            if (s.charAt(j) == t.charAt(i)) {
//                j++;
//            }
//            i++;
//        }
//        return j == s.length();
    }
}
