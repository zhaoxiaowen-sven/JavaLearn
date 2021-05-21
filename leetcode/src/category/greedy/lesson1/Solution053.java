package category.greedy.lesson1;

public class Solution053 {
    public int maxSubArray(int[] nums) {
        int size = nums.length;
        int result = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < size; i++) {
            count += nums[i];
            if (count > result) {
                result = count;
            }
            if (count <= 0) { //相当于重置最大子序起始位置，因为遇到负数一定是拉低总和
                count = 0;
            }
        }
        return result;
    }

    public int maxSubArray2(int[] nums) {
        int size = nums.length;
        int[] dp = new int[size];
        dp[0] = nums[0];
        int res = 0;
        for (int i = 1; i < size; i++) {
            // 要么自成一派，要么和前面的子数组合并
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(dp[i], res);
        }
        return res;
    }

    public static void main(String[] args) {
//        new Solution053().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        new Solution053().maxSubArray(new int[]{-2, -1, -3, -1});
    }
}
