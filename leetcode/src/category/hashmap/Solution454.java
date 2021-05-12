package category.hashmap;

import java.util.HashMap;

public class Solution454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                int value = map.get(i + j) == null ? 0 : map.get(i + j);
                map.put(i + j, ++value);
            }
        }

        for (int i : nums3) {
            for (int j : nums4) {
                int key = -(i + j); //
                if (map.containsKey(key)) {
                    count += map.get(key);
                }
            }
        }
        return count;
    }
}
