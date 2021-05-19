package category.dp.backpack01;

public class Solution494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = getSum(nums);
        if (sum < target || (sum + target) % 2 == 1) {
            return 0;
        }
        target = (sum + target) / 2;
        int n = nums.length;
        int[][] dp = new int[n + 1][target + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (j - nums[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
            // DpUtils.dump(dp);
        }
        return dp[n][target];
    }

    public int findTargetSumWays2(int[] nums, int target) {
        int sum = getSum(nums);
        if (sum < target || (sum + target) % 2 == 1) {
            return 0;
        }
        target = (sum + target) / 2;
        int n = nums.length;
        int[] dp = new int[target + 1];

        for (int i = 0; i <= n; i++) {
            dp[0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = target; j >= nums[i - 1]; j--) { // ！！！ 必须要倒序遍历 ！！！
                dp[j] = dp[j] + dp[j - nums[i - 1]];
            }
        }
        return dp[target];
    }

    private int getSum(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        System.out.println(new Solution494().findTargetSumWays2(nums, 3));
    }
}

