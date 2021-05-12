package category.backtracking.subset;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution078 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();
        dfs(nums, path, lists, 0);
        return lists;
    }

    private void dfs(int[] nums, Deque<Integer> deque, List<List<Integer>> lists, int startIndex) {
        System.out.println(deque);
        lists.add(new ArrayList<>(deque)); // 在这里添加元素的原因是记录所有合理的结果集
        int size = nums.length;
        if (startIndex == size) {
            return;
        }
        for (int i = startIndex; i < size; i++) {
            deque.push(nums[i]);
            dfs(nums, deque, lists, i + 1);
            deque.pop();
        }
    }

    public static void main(String[] args) {
        new Solution078().subsets(new int[] {1,2,3});
    }
}
