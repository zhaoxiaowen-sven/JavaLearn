package category.dp.backpack01;

public class Solution416 {

    public boolean canPartition(int[] nums) {
        int sum = getSum(nums);
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;

        //dp[i][j] 能不能由 i 构成 j;
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        // !!! j = 0 因为背包没有空间的时候
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }
        // dp[i][j]
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j - nums[i] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][target];
    }

    public boolean canPartition2(int[] nums) {
        int sum = getSum(nums);
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        // dp[j] dp 能够构成j
        boolean[] dp = new boolean[target + 1];
        // j = 0,任何数都能构成
        dp[0] = true;
        // dp[j] == dp[j] | dp[j - num[i]]
        // i = 1, nums[0] =1
        // j = 6, dp[6] | dp[6 - 1] = false
        // j = 5/4/3/2 -> dp[5/4/3/2] = true
        // j = 1 , dp[1] = true
        // 其实背包问题真正的判断是 j - nums[i - 1] 来确定的。
        // i = 2 ...
        for (int i = 1; i <= nums.length; i++) {
            for (int j = target; j >= nums[i - 1]; j--) {
                dp[j] = dp[j] | dp[j - nums[i - 1]];
            }
            //DpUtils.dump(dp);
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


    public boolean canPartition3(int[] nums) {
        int sum = getSum(nums);
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;

        // 这道题转换为求背包size = sum/2时，背包的最大值，只有最大值才能构成sum/2
        // dp[i][j] 能不能由 i 构成 j;
        int[][] dp = new int[nums.length + 1][target + 1];
        // dp[i][j]
        for (int i = 1; i <= nums.length; i++) { // 相当于背包问题中物品的个数
            for (int j = 1; j <= target; j++) { //
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
        System.out.println(new Solution416().canPartition(x));
    }
}
