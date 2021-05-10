package backtracking.subset;

import java.util.*;

public class Solution090 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();
        Arrays.sort(nums);
        backtrack(nums, res, path, 0);
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, Deque<Integer> path, int startIndex) {
        res.add(new ArrayList<>(path));
        int size = nums.length;
        if (startIndex == size) {
            return;
        }

        for (int i = startIndex; i < size; i++) {
            if (i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            path.push(nums[i]);
            backtrack(nums, res, path, i + 1);
            path.pop();
        }
    }
}
