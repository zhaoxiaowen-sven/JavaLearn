package category.dp.palindromics;

public class Solution005 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) { // end 和start 相当于记录最新的开始和结束位置
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }


    public String longestPalindrome2(String s) {
        int n = s.length();
        int max = 1;
        int start = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        // 遍历方向 非常重要
        // [i ,j],区间是前闭后闭的
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    start = i;
                }
            }
        }
        // DpUtils.dump(dp);
        return s.substring(start, start + max);
    }

    public static void main(String[] args) {
//        new Solution005().longestPalindrome("a");
//        System.out.println(new Solution005().longestPalindrome2("a"));
//        System.out.println(new Solution005().longestPalindrome2("aacabdkacaa"));
        System.out.println(new Solution005().longestPalindrome2("aaaa"));

    }
}
