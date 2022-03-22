package category.tree.ancestor;

import category.tree.TreeNode;
import category.tree.dfs.base.Solution094;

public class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else if (left != null && right == null) {
            return left;
        } else if (right != null && left == null) {
            return right;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        //  5
        // 4  6
        //1 2
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(4, treeNode1, treeNode2);
        TreeNode treeNode5 = new TreeNode(5, treeNode4, treeNode6);
        TreeNode node = new Solution236().lowestCommonAncestor(treeNode5, treeNode1, treeNode4);
        System.out.println(node.val);
    }
}
