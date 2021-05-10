package backtracking.subset;

import java.util.*;

public class Solution047 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();
        // 排序
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(nums, res, path, used);
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, Deque<Integer> path, boolean[] used) {
        int size = nums.length;
        if (path.size() == size) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < size; i++) {
            // 这一条树枝上不能有重复的
            if (used[i]) {
                continue;
            }
            // i > 0 是为了保证 i-1有意义
            // nums[i-1] == nums [i], 表示出现重复
            // used[i - 1] == false ，表示回退中刚刚撤销选择
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }
            used[i] = true;
            path.addLast(nums[i]);
            backtrack(nums, res, path, used);
            path.removeLast();
            used[i] = false;
        }
    }

    private void dump(boolean[] used) {
        StringBuilder builder = new StringBuilder();
        for (boolean b : used) {
            builder.append(b).append(", ");
        }
        System.out.println(builder.toString());
    }


    public static void main(String[] args) {
        new Solution047().permute(new int[]{1, 1, 1});
    }
}
