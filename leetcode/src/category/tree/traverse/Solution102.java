package category.tree.traverse;

import java.util.*;

public class Solution102 {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        // 1.初始化
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);

        // 2.开始遍历
        while (!nodeQueue.isEmpty()) {
            // 当前层拥有的节点个数
            int count = nodeQueue.size();
            List<Integer> level = new ArrayList<>();

            //3. 遍历每一层的节点
            while (count > 0) {
                TreeNode node = nodeQueue.poll();
                level.add(node.val);

                if (node.left != null) { // 顺序添加左右节点
                    nodeQueue.offer(node.left);
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                }
                count--;
            }
            ans.add(level);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(4, treeNode1, treeNode2);
        TreeNode treeNode5 = new TreeNode(5, treeNode4, treeNode6);

        List<List<Integer>> ans = new Solution102().levelOrder(treeNode5);

        StringBuilder stringBuilder = new StringBuilder();
        for (List<Integer> l : ans) {
            for (int i : l) {
                stringBuilder.append(i);
                stringBuilder.append(",");
            }
            stringBuilder.append("\n");
        }
        System.out.print(stringBuilder.toString());
    }
}
