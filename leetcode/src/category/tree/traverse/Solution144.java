package category.tree.traverse;

import java.util.*;

public class Solution144 {
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
    // 1.确定递归函数的参数和返回值
    public List<Integer> preorderTraversal(TreeNode root) {
//        // 2.确定终止条件
//        if (root == null) {
//            return Collections.emptyList();
//        }
//        // 3.确定单层递归条件
//        List<Integer> list = new ArrayList<>();
//        list.add(root.val);
//        list.addAll(preorderTraversal(root.left));
//        list.addAll(preorderTraversal(root.right));
//        return list;
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                list.add(root.val); //
                stack.push(root); // 中
                root = root.left; // 左
            }

            TreeNode node = stack.pop();
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

        List<Integer> ans = new Solution144().preorderTraversal(treeNode5);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i : ans) {
            stringBuilder.append(i);
            stringBuilder.append(",");
        }
        System.out.print(stringBuilder.toString());
    }
}
