package category.tree.dfs.base;

import java.util.*;

public class Solution145 {
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

    public List<Integer> postorderTraversal(TreeNode root) {
//        // 2.确定终止条件
//        if (root == null) {
//            return Collections.emptyList();
//        }
//        // 3.确定单层递归条件
//        List<Integer> list = new ArrayList<>();
//        list.addAll(postorderTraversal(root.left));
//        list.addAll(postorderTraversal(root.right));
//        list.add(root.val);
//        return list;

//        List<Integer> list = new ArrayList<>();
//        Deque<TreeNode> stack = new LinkedList<>();
//
//        // 左右中比较复杂，先仿照前序遍历求得中右左，再逆序得到 左右中即可
//        while (root != null || !stack.isEmpty()) {
//            while (root != null) {
//                list.add(root.val);
//                stack.push(root); // 中
//                root = root.right; // 右
//            }
//
//            TreeNode node = stack.pop();
//            root = node.left; // 左
//        }
//        // 逆序
//        Collections.reverse(list);
//        return list;


        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);

            // 后序遍历 反着来
            if (node.left != null) {
                stack.push(node.left);
            }

            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(res);
        return res;
    }
    public static void main(String[] args) {
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(4, treeNode1, treeNode2);
        TreeNode treeNode5 = new TreeNode(5, treeNode4, treeNode6);

        List<Integer> ans = new Solution145().postorderTraversal(treeNode5);

//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i : ans) {
//            stringBuilder.append(i);
//            stringBuilder.append(",");
//        }
//        System.out.print(stringBuilder.toString());

        new Solution145().postorderTraversal2(treeNode5);
    }

    public String postorderTraversal2(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String l = postorderTraversal2(root.left);
        String r = postorderTraversal2(root.right);
        // 记录后序遍历过程中的每一个节点
        String path = l + ", " + r + ", " + root.val;
        System.out.println(path);
        return path;
    }


}
