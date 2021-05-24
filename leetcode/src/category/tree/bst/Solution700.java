package category.tree.bst;

import category.tree.TreeNode;

public class Solution700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val == root.val) {
            return root;
        } else if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(4, treeNode3, treeNode6);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode5 = new TreeNode(5, treeNode1, treeNode4);

        System.out.print(new Solution700().searchBST(treeNode5, 0));
    }
}
