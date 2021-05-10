package backtracking.subset;

import java.util.*;

public class Solution491 {

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();
        // 不能排序
        // Arrays.sort(nums);
        backtrack(nums, res, path, 0);
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, Deque<Integer> path, int startIndex) {
        int size = nums.length;
        if (path.size() >= 2) {
            System.out.println(path);
            res.add(new ArrayList<>(path));
            //  这里坚决不能加return
            //  return;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = startIndex; i < size; i++) {
            if ((path.size() > 0 && nums[i] < path.peekLast()) // 序列是递增的
                    //这一层上不能有重复的
                    || set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            path.addLast(nums[i]);
            backtrack(nums, res, path, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        new Solution491().findSubsequences(new int[]{4, 7, 6, 7});
    }
}
