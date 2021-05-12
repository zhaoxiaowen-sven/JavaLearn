package category.backtracking.array;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution077 {
    public List<List<Integer>> combine(int n, int k) {
        // 1.结果集
        List<List<Integer>> result = new ArrayList<>();
        // 2.收集路径
        Deque<Integer> path = new LinkedList<>();

        dfs(n, k, 1, path, result);

        return result;
    }

    private void dfs(int n, int k, int startIndex, Deque<Integer> path, List<List<Integer>> list) {
        System.out.println("dfs " + path + " startIndex " + startIndex);
//        if (path.size() == k) {
            list.add(new ArrayList<>(path));
//            return;
//        }
        for (int i = startIndex; i <= n; i++) {
            path.push(i);
//            System.out.println("push " + i + "startIndex = " +startIndex);
            // 1 走到这后开启一个for循环 ， 2，3，4 的dfs只能走一次 然后就退出 ，接着就到 2开始
            dfs(n, k, i + 1, path, list);
            int x = path.pop(); // 回溯
//            System.out.println("pop => " + x +"startIndex = " +startIndex);
        }
    }
            //栈中情况
/*    push 1 -->  1
    push 2   --> 递归 1,2
    pop => 2 --> 递归退出 1
    push 3  --> 1,3
    pop => 3 --> 1
    push 4  --> 1,4
    pop => 4
    pop => 1
    push 2
    push 3
    pop => 3
    push 4
    pop => 4
    pop => 2
    push 3
    push 4
    pop => 4
    pop => 3
    push 4
    pop => 4*/

    public static void main(String[] args) {
        List<List<Integer>> res = new Solution077().combine(3, 2);

//        Deque<String> deque = new LinkedList<>();
//        deque.add("1");
//        deque.add("2");
//        deque.add("3");


    }
}
