package category.greedy;

public class Solution376 {
    public int wiggleMaxLength(int[] nums) {
        int curDiff = 0;
        int preDiff = 0;
        int size = nums.length;

        // i 从 1开始
        int res = 1; // 默认左边有一个峰值
        for (int i = 1; i < size; i++) {
            curDiff = nums[i] - nums[i - 1];
            //峰值转峰谷 +  峰谷转峰值
            if (preDiff >= 0 && curDiff < 0 || preDiff <= 0 && curDiff > 0) {
                res++;
//                System.out.println(nums[i]);
                preDiff = curDiff;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution376().wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8});
    }
}
