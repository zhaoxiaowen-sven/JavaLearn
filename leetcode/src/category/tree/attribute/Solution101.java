package category.tree.attribute;

//   https://leetcode-cn.com/problems/symmetric-tree/
public class Solution101 {

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

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        // step1.确定的递归的参数和返回值，判断左 右节点是不是对称的
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        // step2.确定终止条件
        if (left == null && right == null) { // 1.左右为空的情况，都为空
            return true;
        } else if (left == null && right != null) { // 2.左空，右不空
            return false;
        } else if (left != null && right == null) { // 3.有空左不空
            return false;
        } else {
            if (left.val != right.val) { // 4.左右都不为空，判断值是否相同
                return false;
            } else { // 5.左右不为空且都相同的情况下，继续比较当前节点的左右的情况，递归
                     // 左节点的左孩子 和 右节点的有孩子 ； 左节点的右孩子和右节点的左孩子
                return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
            }
        }
    }
}
