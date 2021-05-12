package category.hashmap;

import java.util.HashMap;

public class Solution001 {
    public int[] twoSum(int[] nums, int target) {
//      使用哈希法来确定 0-(a+b) 是否在 数组里
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i]; // 减完的数在map里就说明找到了
            if (map.containsKey(x)) {
                return new int[]{map.get(x),i};
            } else {
                map.put(nums[i], i); // 存的是 值 -> 索引
            }
        }
        return null;
    }
}
