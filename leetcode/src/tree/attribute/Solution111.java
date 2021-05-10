package tree.attribute;

// https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
public class Solution111 {
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

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHigh = minDepth(root.left);
        int rightHigh = minDepth(root.right);
        // 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。，注意是叶子节点。
        // 当一个左子树为空，右不为空，这时并不是最低点

//        if (root.left == null && root.right != null) {
//            return 1 + rightHigh;
//        }
        // 当一个右子树为空，左不为空，这时并不是最低点

//        if (root.right == null && root.left != null) {
//            return 1 + leftHigh;
//        }
//        return 1 + Math.min(leftHigh, rightHigh);


        if (root.left == null && root.right != null) {
            return 1 + rightHigh;
        } else if (root.right == null && root.left != null) {
            return 1 + leftHigh;
        } else if (root.right == null && root.left == null) {
            return 1;
        } else {
            return 1 + Math.min(leftHigh, rightHigh);
        }

//        Deque<TreeNode> treeNodes = new LinkedList<>();
//        treeNodes.offer(root);
//        int minDepth = 0;
//        while (!treeNodes.isEmpty()) {
//            int size = treeNodes.size();
//            minDepth++;
//            while (size > 0) {
//                TreeNode treeNode = treeNodes.poll();
//                if (treeNode.left == null && treeNode.right == null) {
//                    return minDepth;
//                }
//                if (treeNode.left != null) {
//                    treeNodes.offer(treeNode.left);
//                }
//                if (treeNode.right != null) {
//                    treeNodes.offer(treeNode.right);
//                }
//                size--;
//            }
//        }
//        return minDepth;
    }
}
