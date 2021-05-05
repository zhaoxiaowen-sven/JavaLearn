package hot100;

import java.util.Arrays;

public class Solution034 {
    public int[] searchRange(int[] nums, int target) {
//        int start = 0;
//        int end = nums.length - 1;
//        int i = -1;
//        int j = -1;
//        while (start <= end) {
//            if (i >= 0 && j >= 0) {
//                break;
//            }
//
//            if (i < 0) {
//                if (target == nums[start]) {
//                    i = start;
//                } else {
//                    start++;
//                }
//            }
//
//            if (j < 0) {
//                if (target == nums[end]) {
//                    j = end;
//                } else {
//                    end--;
//                }
//            }
//        }
//        return new int[]{i , j};

        // 1. 右边界，左侧逼近
        int right = binary(nums,target,true);
        // 2. 左边界，右侧逼近
        int left = binary(nums,target,false);
        return new int[]{left, right};
    }

    private int binary(int[] nums, int target, boolean fromLeft) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                ans = mid;
                if (fromLeft) { // 相同的时候处理不同
                    start = mid + 1; // 最右的的值
                } else {
                    end = mid - 1; //
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7,7,8,8, 10};
        new Solution034().searchRange(nums, 1);
    }
}
