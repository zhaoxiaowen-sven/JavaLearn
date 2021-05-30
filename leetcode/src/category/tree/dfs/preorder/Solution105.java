package category.tree.dfs.preorder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Solution105 {

    //Definition for a binary tree node.
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

    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTree(int[] preorder, int pleft, int pRight, int[] inorder, int iLeft, int iRight) {
        if (iRight - iLeft <= 0) {
            return null;
        }

        int splitVal = preorder[pleft];
        int splitIndex = map.get(splitVal);
        TreeNode root = new TreeNode(splitVal);
        if (iRight - iLeft == 1) {
            return root;
        }
        // 中序遍历左部分的分割范围
        // ileft
        root.left = buildTree(preorder, pleft + 1, pleft + 1 + (splitIndex - iLeft), // 起始索引 + 区间大小
                inorder, iLeft, splitIndex);
        root.right = buildTree(preorder, pleft + 1 + (splitIndex - iLeft), pRight, inorder, splitIndex + 1, iRight);
        return root;
    }

    public static void main(String[] args) {

        int[] preorder = {3, 9, 20, 15, 7};

        int[] inOrder = {9, 3, 15, 20, 7};
//        TreeNode treeNode = new Solution106().buildTree(inOrder, postOrder);
        TreeNode treeNode = new Solution105().buildTree(preorder, inOrder);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i : new Solution105().preorderTraversal(treeNode)) {
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
        list.addAll(preorderTraversal(root.left));
        list.addAll(preorderTraversal(root.right));
        list.add(root.val);
        return list;
    }
}
