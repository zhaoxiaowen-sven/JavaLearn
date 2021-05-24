package category.tree.bst;

import category.tree.TreeNode;

public class Solution098 {

    int max = Integer.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST(root.left);
        if (root.val < max) {
            return false;
        }
        max = root.val;
        boolean right = isValidBST(root.right);
        return left && right;
    }

    TreeNode pre = null;
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean left = isValidBST2(root.left);
        if (pre != null && pre.val >= root.val) {
            return false;
        }
        pre = root;

        boolean right = isValidBST2(root.right);
        return left && right;
    }

    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(4, treeNode3, treeNode6);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(5, treeNode1, treeNode4);

        System.out.print(new Solution098().isValidBST2(treeNode5));
    }
}
