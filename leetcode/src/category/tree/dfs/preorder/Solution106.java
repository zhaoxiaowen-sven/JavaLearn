package category.tree.dfs.preorder;

import java.util.*;

public class Solution106 {

    // Definition for a binary tree node.
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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = postorder.length;
        if (length == 0 || inorder.length != length) {
            return null;
        }

        int rootVal = postorder[length - 1];
        TreeNode root = new TreeNode(rootVal);

        // 只有一个节点
        if (length == 1) {
            return root;
        }

        int inOrderSplitIndex = 0;
        while (inOrderSplitIndex < length) {
            if (inorder[inOrderSplitIndex] == rootVal) {
                break;
            }
            inOrderSplitIndex++;
        }
        // 切割中序数组
        // 左闭右开区间：[0, inOrderSplitIndex)
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, inOrderSplitIndex);
        int[] rightInorder = Arrays.copyOfRange(inorder, inOrderSplitIndex + 1, length);

        // 切割后序数组
        // 依然左闭右开，注意这里使用了左中序数组大小作为切割点
        // [0, leftInorder.size)
        int leftInorderLen = leftInorder.length;
        int[] leftPostOrder = Arrays.copyOfRange(postorder, 0, leftInorderLen);
        int[] rightPostOrder = Arrays.copyOfRange(postorder, leftInorderLen, leftInorderLen + rightInorder.length);

        root.left = buildTree(leftInorder, leftPostOrder);
        root.right = buildTree(rightInorder, rightPostOrder);
        return root;
    }

    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    // 注意区间范围是 [)
    private TreeNode buildTree(int[] inorder, int inorderLeft, int inorderRight, int[] postOrder, int pLeft, int pRight) {
        int len = inorderRight - inorderLeft;
        if (len <= 0) {
            return null;
        }
        int rootVal = postOrder[pRight - 1];
        TreeNode root = new TreeNode(rootVal);
        if (len == 1) {
            return root;
        }
        // 通过hashMap 优化中序遍历中 root节点的索引查找
        int inorderSplit = map.get(rootVal);
        //int inorderSplit = inorderLeft;
        //while (inorderSplit < len) {
        //    if (inorder[inorderSplit] == rootVal) {
        //        break;
        //    }
        //    inorderSplit++;
        //}

        // 中序的左区间 + 后序的左
        root.left = buildTree(inorder, inorderLeft, inorderSplit, postOrder,
                pLeft, pLeft + inorderSplit - inorderLeft);
        // 中序的右 + 后序的右
        root.right = buildTree(inorder, inorderSplit + 1, inorderRight,
                postOrder, pLeft + inorderSplit - inorderLeft, pRight - 1);
        return root;
    }


    public static void main(String[] args) {
        int[] inOrder = {9, 3, 15, 20, 7};
        int[] postOrder = {9, 15, 7, 20, 3};
//        TreeNode treeNode = new Solution106().buildTree(inOrder, postOrder);
        TreeNode treeNode = new Solution106().buildTree2(inOrder, postOrder);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i : new Solution106().preorderTraversal(treeNode)) {
            stringBuilder.append(i);
            stringBuilder.append(",");
        }
        System.out.print(stringBuilder.toString());

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        // 2.确定终止条件
        if (root == null) {
            return Collections.emptyList();
        }
        // 3.确定单层递归条件
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        list.addAll(preorderTraversal(root.left));
        list.addAll(preorderTraversal(root.right));
        return list;
    }
}
