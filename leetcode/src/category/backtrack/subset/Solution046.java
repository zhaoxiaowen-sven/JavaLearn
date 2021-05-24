package category.backtrack.subset;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution046 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();

        boolean[] used = new boolean[nums.length];
        backtrack(nums, res, path, used);
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, Deque<Integer> path, boolean[] used) {
        int size = nums.length;
        if (path.size() == size) {
            System.out.println(path);
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < size; i++) {

            //   这一条树上不能有重复的，解法2， 效率没有used高
            //  if (path.contains(nums[i])) {
            //      continue;
            //  }
            //   这一条树上不能有重复的，解法1
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.addLast(nums[i]);
            backtrack(nums, res, path, used);
            path.removeLast();
            used[i] = false;
        }
    }
}
