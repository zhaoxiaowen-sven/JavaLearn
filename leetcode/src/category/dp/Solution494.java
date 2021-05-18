package category.dp;

public class Solution494 {

    int result = 0;

    public int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        dfs(nums, target,0, nums.length);
        return result;
    }

    private void dfs(int[] nums, int target,  int startIndex, int size) {
        if (startIndex == size) {
            if (target == 0) {
                result++;
            }
            return;
        }

        dfs(nums, target -= nums[startIndex], startIndex + 1, size);
        dfs(nums, target += nums[startIndex], startIndex + 1, size);
    }

}
