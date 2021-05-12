package category.greedy;

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

    public static void main(String[] args) {
//        new Solution053().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        new Solution053().maxSubArray(new int[]{-2,-1,-3,-1});
    }
}
