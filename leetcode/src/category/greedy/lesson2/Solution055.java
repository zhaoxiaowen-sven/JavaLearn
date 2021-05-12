package category.greedy.lesson2;

public class Solution055 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int cover = nums[0] + 0; // 先走第一步
        if (cover >= n - 1) {
            return true;
        }
        // 注意区间是闭区间 []
        // 在覆盖范围进行寻找是否覆盖到尾部，
        // 范围是通过索引进行判断的，所以上限是n-1
        for (int i = 1; i <= cover; i++) {
            cover = Math.max(nums[i] + i, cover);
            if (cover >= n - 1) {
                return true;
            }
        }
        return false;
        /*
        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(nums[i] + i, cover);
            if (cover >= n - 1) {
                return true;
            }
        }
        return false;
        */
    }

    public static void main(String[] args) {
        new Solution055().canJump(new int[]{2, 1});
    }
}
