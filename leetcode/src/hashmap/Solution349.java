package hashmap;

import java.util.*;

public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int i : nums2) {
            if(set1.contains(i)) {
                set2.add(i);
            }
        }

        int[] arr = new int[set2.size()];
        Object[] arr1 = set2.toArray();
        for (int i = 0 ; i<set2.size() ; i++) {
            arr[i] = (int)arr1[i];
        }
        return arr;
    }
}
