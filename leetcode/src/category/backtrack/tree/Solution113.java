package category.backtrack.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution113 {

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();

        dfs(root, targetSum, path, res);
        return res;
    }

    private void dfs(TreeNode root, int targetSum, Deque<Integer> path, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                path.addLast(root.val);
                res.add(new ArrayList<>(path));
                path.removeLast();
            }
            return;
        }

        if (root.left != null) {
            path.addLast(root.val);
            dfs(root.left, targetSum - root.val, path, res);
            path.removeLast();
        }

        if (root.right != null) {
            path.addLast(root.val);
            dfs(root.right, targetSum - root.val, path, res);
            path.removeLast();
        }
    }
}
