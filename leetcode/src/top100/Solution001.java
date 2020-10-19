package top100;

public class Solution001 {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i ++) {
            for (int j = i+1; j<nums.length; j ++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i ,j};
                }
            }
        }
        return new int[0];
    }

    public void test() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        for (int e : result) {
            System.out.println(e);
        }
    }
}
