package hashmap;

import java.util.HashMap;

public class Solution001 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i]; // 减完的数在map里就说明找到了
            if (map.containsKey(x)) {
                return new int[]{map.get(x),i};
            } else {
                map.put(x, i); // 存的是 值 -> 索引
            }
        }
        return null;
    }
}
