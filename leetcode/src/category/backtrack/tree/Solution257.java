package category.backtrack.tree;

import java.util.*;

public class Solution257 {

    //Definition for a binary category.tree node.
    static class TreeNode {
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

    private void binaryTreePaths(TreeNode root,  String temp, List<String> result) {
        if (root.left == null && root.right == null) {
            result.add(temp + root.val);
            return;
        }
        if (root.left != null) {
            binaryTreePaths(root.left, temp + root.val + "->", result); // 回溯
        }
        if (root.right != null) {
            binaryTreePaths(root.right, temp + root.val + "->", result);// 回溯
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        binaryTreePaths(root, "", result);
        return result;

//        if (root == null) {
//            return Collections.emptyList();
//        }
//        Queue<TreeNode> queue = new LinkedList<>();
//        Queue<String> paths = new LinkedList<>(); // 记录遍历到的路径
//        List<String> ans = new ArrayList<>();
//        queue.offer(root);
//        paths.offer(String.valueOf(root.val));
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            while (size > 0) {
//                TreeNode treeNode = queue.poll();
//                String path = paths.poll();
//                if (treeNode.left == null && treeNode.right == null) {
//                    ans.add(path); // 有效路径
//                } else {
//                    if (treeNode.left != null) { // 层序遍历所有路径
//                        queue.offer(treeNode.left);
//                        paths.offer(path + "->" + treeNode.left.val);
//                    }
//
//                    if (treeNode.right != null) {
//                        queue.offer(treeNode.right);
//                        paths.offer(path + "->" + treeNode.right.val);
//                    }
//                }
//                size--;
//            }
//        }
//        return ans;
    }

    public static void main(String[] args) {
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(4, treeNode1, treeNode2);
        TreeNode treeNode5 = new TreeNode(5, treeNode4, treeNode6);

        List<String> ans = new Solution257().binaryTreePaths(treeNode5);

        StringBuilder stringBuilder = new StringBuilder();
        for (String i : ans) {
            System.out.println(i);
        }
    }
}
