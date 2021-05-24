package category.backtrack.array;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution216 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();

        Deque<Integer> path = new LinkedList<>();

        dfs(n, k, 1, path, res);

        return res;
    }

    private void dfs(int targetNum, int k, int starIndex, Deque<Integer> path, List<List<Integer>> res) {
        int size = path.size();
        if (size == k) {
            if (targetNum == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = starIndex; i <= 9 - (k - size) + 1; i++) {
            path.push(i);
            targetNum -= i; //
            //   // startIndex参数用来记录本层递归的中，集合从哪里开始遍历（集合就是[1,...,n] ）。
            dfs(targetNum, k, i + 1, path, res);
            targetNum += i; // 回溯
            path.pop();
        }
    }
}
