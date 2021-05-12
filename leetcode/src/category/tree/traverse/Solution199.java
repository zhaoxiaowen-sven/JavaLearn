package category.tree.traverse;

import java.util.*;

public class Solution199 {
    // Definition for a binary category.tree node.
    public static class TreeNode {
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

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        // 1.初始化
        List<Integer> l = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {// 利用广度优先搜索进行层次遍历，记录下每层的最后一个元素。
                TreeNode node = queue.poll();
                if (i == size - 1) {
                    l.add(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return l;
    }

    public static void main(String[] args) {
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(4, treeNode1, treeNode2);
        TreeNode treeNode5 = new TreeNode(5, treeNode4, treeNode6);

        List<Integer> ans = new Solution199().rightSideView(treeNode5);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i : ans) {
            stringBuilder.append(i);
            stringBuilder.append(",");
        }
        System.out.print(stringBuilder.toString());
    }
}
