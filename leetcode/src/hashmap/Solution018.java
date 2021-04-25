package hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution018 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return Collections.emptyList();
        }

        List<List<Integer>> arrayList = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int partNum = nums[i] + nums[j];
                int begin = j + 1;
                int end = nums.length - 1;
                while (begin < end) {
                    int remain = nums[begin] + nums[end] + partNum - target;
                    if (remain == 0) {
                        arrayList.add(Arrays.asList(nums[i], nums[j], nums[begin], nums[end]));
                        while (begin < end && nums[begin] == nums[begin + 1]) {
                            begin++;
                        }
                        while (begin < end && nums[end] == nums[end - 1]) {
                            end--;
                        }
                        begin++;
                        end--;
                    } else if (remain < 0) {
                        begin++;
                    } else {
                        end--;
                    }
                }
            }
        }
        return arrayList;
    }
}
