package top100;

public class solution005 {

    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int oddLen = expandAroundCenter(s, i, i);
            int evenLen = expandAroundCenter(s, i, i + 1);
            int max = Math.max(oddLen, evenLen);
            if (max > end - start) {
                end = i + max / 2;
                // 综合偶数回文和奇数回文的表达式
                start = i - (max - 1) / 2;
            }
        }
        // 索引值 含头不含尾， 尾部要加1
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 不满足条件时，right是比目标值多1，left比目标值小1
        return right - left - 1;
    }

    // 动态规划算法，i,j表示范围， 如果 d[i] = d[j],那就只需要考虑d[i + 1] 和 d[j-1]
    // j -1 -(i + 1) + 1< 2 (区间范围至少有一个数，如果只有一个数，也算是回文的) => j - i < 3
    public String longestPalindrome2(String s) {
        int len = s.length();
        int max = 0;
        int start = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        // 从列开始填，左下角先填
        for (int j = 0; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + max);
    }
}
