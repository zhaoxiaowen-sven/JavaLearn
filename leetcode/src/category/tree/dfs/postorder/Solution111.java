package category.tree.dfs.postorder;

// https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
public class Solution111 {
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

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。，注意是叶子节点。
        // 当一个左子树为空，右不为空，这时并不是最低点
        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftHigh = minDepth(root.left);
        int rightHigh = minDepth(root.right);
        // 如果右子树为空，则返回左子树
        if (root.left == null) {
            return 1 + rightHigh;
        }
        // 如果左子树为空，则返回右子树
        if (root.right == null) {
            return  1 + leftHigh;
        }

        // 左右均不为空，则返回较小的
        return 1 + Math.min(leftHigh, rightHigh);
    }
}
