package category.backtracking.array;

import java.util.*;

public class Solution039 {
    int count = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Deque<Integer> path = new LinkedList<>();
        // target 目标值，
        Arrays.sort(candidates);
        dfs(target, candidates, 0, path, result);
        System.out.println(count);
        return result;
    }

    private void dfs(int target, int[] candidates, int startIndex, Deque<Integer> path, List<List<Integer>> list) {
        if (target < 0) { // 剪枝
            count ++;
            return;
        }
        if (target == 0) {
            list.add(new ArrayList<>(path));
            return;
        }
        int size = candidates.length;
        for (int i = startIndex; i < size && target >= candidates[i]; i++) {
            int tmp = candidates[i];
            path.push(tmp);
            target -= tmp; // target
            dfs(target, candidates, i, path, list); // 不用i+1了，表示可以重复读取当前的数
            target += tmp;
            path.pop(); // 回溯
        }
    }

    public static void main(String[] args) {
        new Solution039().combinationSum(new int[]{3, 2, 6, 7}, 7);
    }
}
