package category.tree.bst;

import category.tree.TreeNode;

public class Solution530 {
    int min = Integer.MAX_VALUE;
    TreeNode preNode = null;
    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return min;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        getMinimumDifference(root.left);
        if (preNode != null) {
            min = Math.min(root.val - preNode.val, min);
        }
        preNode = root;
        getMinimumDifference(root.right);
    }
}
