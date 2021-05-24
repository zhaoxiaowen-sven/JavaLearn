package category.backtrack.string;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution131 {
    static int count = 1;

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        Deque<String> path = new LinkedList<>();
        dfs(s, 0, path, res);
        return res;
    }

    private void dfs(String s, int startIndex, Deque<String> path, List<List<String>> res) {
        int size = s.length();
        if (startIndex == size) {
            // 切割到最后收集结果
            res.add(new ArrayList<>(path));
            return;
        }

        // startIndex 表示这一层开始切的位置，循环开始的位置
        // [startIndex, i] 代表的是递归过程中子串搜索的范围
        for (int i = startIndex; i < size; i++) {
            if (!isPalindrome(s, startIndex, i)) {
                continue;
            }
            String subStr = s.substring(startIndex, i + 1);
            // System.out.println("add str = " + subStr + "， startIndex = " + startIndex + ", i= " + i);
            path.addLast(subStr);
            // 继续切割，！！！切割过的地方不能再切割！！！
            dfs(s, i + 1, path, res);
            path.removeLast();
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start >= 0 && start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> lists = new Solution131().partition("abc");
        for (List<String> l : lists) {
            for (String s : l) {
                System.out.println(s);
            }
        }
    }
}
