package category.tree.traverse;

import java.util.LinkedList;
import java.util.Queue;

public class Solution226 {
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

    public TreeNode invertTree(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//        swap(root);
//        invertTree(root.left);
//        invertTree(root.right);
//        return root;

        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                swap(node);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }

    private void swap(TreeNode root) {
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
    }
}
