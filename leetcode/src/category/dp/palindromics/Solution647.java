package category.dp.palindromics;

import category.dp.backpack01.DpUtils;

public class Solution647 {

    int nums = 0;

    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    nums++;
                } else {
                    dp[i][j] = false;
                }
            }
            DpUtils.dump(dp);
        }
        return nums;
    }

    public static void main(String[] args) {
        new Solution647().countSubstrings("ababa");
    }
}
