package category.tree.dfs.postorder;

import java.util.Deque;
import java.util.LinkedList;

public class Solution104 {

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

    public int maxDepth(TreeNode root) {
        // 解法1：递归
//        if (root == null) {
//            return 0;
//        }
//        int leftHigh = maxDepth(root.left);
//        int rightHigh = maxDepth(root.right);
//        return 1 + Math.max(leftHigh, rightHigh);

        // 解法2：层序遍历
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root);
        int sum = 0;
        while (!treeNodes.isEmpty()) {
            int size = treeNodes.size();
            while (size > 0) {
                TreeNode treeNode = treeNodes.poll();
                if (treeNode.left != null) {
                    treeNodes.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    treeNodes.offer(treeNode.right);
                }
                size--;
            }
            sum += 1;
        }
        return sum;
    }
}
