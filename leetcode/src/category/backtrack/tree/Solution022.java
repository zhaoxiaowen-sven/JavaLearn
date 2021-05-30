package category.backtrack.tree;

import java.util.ArrayList;
import java.util.List;

public class Solution022 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        dfs(res, "", n, 0, 0);
        return res;
    }

    private void dfs(List<String> res, String path, int size, int open, int close) {
        if (close > open || open > size) {
            return;
        }
        if (path.length() == size * 2) {
            res.add(path);
            return;
        }
        dfs(res, path + "(", size, open + 1, close);
        dfs(res, path + ")", size, open, close + 1);
    }

    public static void main(String[] args) {
        List<String> res = new Solution022().generateParenthesis(2);
        for (String s : res) {
            System.out.println(s);
        }
    }
}
