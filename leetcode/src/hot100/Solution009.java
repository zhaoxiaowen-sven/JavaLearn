package hot100;

import java.util.*;
import java.util.concurrent.BlockingDeque;

public class Solution009 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int left = i;
            int right = len - 1;
            if (nums[i] > 0) {
                break;
            }
            // 错误去重方法，将会漏掉-1,-1,2 这种情况
            /*
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            */
            if (i > 0 && nums[i] == nums[i - 1]) { // i -1 和 i 比较的意思 相当于前面数组找过了 才能在跳过
                continue;
            }
            while (left < right) {
                int ret = nums[i] + nums[left] + nums[right];
                if (ret == 0) {
                    list.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                } else if (ret < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return list;
    }

    public void test() {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = threeSum(nums);
        for (List<Integer> e : list) {
            for (int i : e) {
                System.out.print(i + ",");
            }
            System.out.println("\n ====");
        }
    }
}
