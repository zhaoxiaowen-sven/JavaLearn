package category.tree.dfs.preorder;

public class Solution617 {

    // Definition for a binary category.tree node.
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


    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }

        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        root1.val = root1.val + root2.val;

        root1.left = mergeTrees(root1.left, root2.left); // 如果root1 为空了，加完之后要把root2赋值给root1

        root1.right = mergeTrees(root1.right, root2.right);

        return root1;
    }
}
