package category.tree.traverse;

import java.util.*;

public class Solution094 {

    // Definition for a binary category.tree node.
     public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

    public List<Integer> inorderTraversal(TreeNode root) {
//        if(root == null) {
//            return Collections.emptyList();
//        }
//        List<Integer> list = new ArrayList<>();
//        list.addAll(inorderTraversal(root.left));
//        list.add(root.val);
//        list.addAll(inorderTraversal(root.right));
//        return list;

        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) { // !!! 注意 条件是或
            while (root != null) {
                stack.push(root); // 一直找到最左
                root = root.left; //左
            }
            TreeNode node = stack.pop(); // 到达叶子节点后，开始出栈
            list.add(node.val);// 叶子节点或者中
            root = node.right; // 右
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(4, treeNode1, treeNode2);
        TreeNode treeNode5 = new TreeNode(5, treeNode4, treeNode6);

        List<Integer> ans = new Solution094().inorderTraversal(treeNode5);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i : ans) {
            stringBuilder.append(i);
            stringBuilder.append(",");
        }
        System.out.print(stringBuilder.toString());
    }
}
