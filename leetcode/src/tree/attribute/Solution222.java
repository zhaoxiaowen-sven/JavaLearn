package tree.attribute;
//https://leetcode-cn.com/problems/count-complete-tree-nodes/
public class Solution222 {
    // Definition for a binary tree node.
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


    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftCount = countNodes(root.left); // 左
        int rightCount = countNodes(root.right); // 右
        return 1 + leftCount + rightCount; // 中
    }
}
