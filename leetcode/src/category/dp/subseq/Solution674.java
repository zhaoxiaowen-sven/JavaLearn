package category.dp.subseq;

import java.util.Arrays;

public class Solution674 {
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
        }

        int res = 0;
        for (int i : dp) {
            res = Math.max(i, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7};
        new Solution674().findLengthOfLCIS(nums);
    }
}
