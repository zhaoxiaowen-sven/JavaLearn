package tree.attribute;

import java.util.LinkedList;
import java.util.Queue;

public class Solution112 {

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

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> levelCount = new LinkedList<>();
        queue.offer(root);
        levelCount.offer(root.val);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode treeNode = queue.poll();
                int count = levelCount.poll();
                if (treeNode.left == null && treeNode.right == null) {
                    if (count == targetSum) {
                        return true;
                    }
                } else {
                    if (treeNode.left != null) { // 层序遍历所有路径
                        queue.offer(treeNode.left);
                        levelCount.offer(count + treeNode.left.val);
                    }
                    if (treeNode.right != null) {
                        queue.offer(treeNode.right);
                        levelCount.offer(count + treeNode.right.val);
                    }
                }
                size--;
            }
        }

        return false;
    }
}
