package array;

public class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        int size = Integer.MAX_VALUE;
        int slowIndex = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                int len = i - slowIndex + 1;
                size = Math.min(size, len);
                sum -= nums[slowIndex];
                slowIndex++; // 缩小窗口
            }
        }
        return size == Integer.MAX_VALUE ? 0 : size;
    }
}
