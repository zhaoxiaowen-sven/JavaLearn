package category.dp.backpack;

public class Solution416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        // dp[i] 数组的含义，取i个数的最大值
        int[] dp = new int[target + 1];
        // 初始化是 0
        // 递推公式
        // dp[j] == max(dp[j], dp[j - num[i]] + value[i];
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                // 物品是nums[i]，重量是nums[i]i，价值也是nums[i]
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                if (dp[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;

        //dp[i][j] 能不能由 i 构成 j;
        boolean[][] dp = new boolean[nums.length + 1][target + 1];

        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }
        // dp[i][j]
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j - nums[i] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 前面 i-1 个数是不是能填充 j - nums[i - 1], i -1 表示当前数。
                    // 有没有大于的情况
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][target];
    }

    public boolean canPartition3(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;

        // 这道题转换为求背包size = sum/2时，背包的最大值，只有最大值才能构成sum/2
        // dp[i][j] 能不能由 i 构成 j;
        int[][] dp = new int[nums.length + 1][target + 1];
        // dp[i][j]
        for (int i = 1; i <= nums.length; i++) { // 相当于背包问题中物品的个数
            for (int j = 1; j <= target; j++) { // w
                if (j - nums[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j],
                            dp[i - 1][j - nums[i - 1]] + nums[i - 1]); // 注意括号范围
                }
            }
        }
//        DpUtils.dumpDp(dp);
        return dp[nums.length][target] == target;
    }


    public static void main(String[] args) {
        int[] x = new int[]{1, 2, 2, 5};
        System.out.println(new Solution416().canPartition3(x));
    }
}
