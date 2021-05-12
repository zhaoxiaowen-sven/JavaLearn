package category.tree.attribute;

public class Solution404 {
   //Definition for a binary category.tree node.
   static class TreeNode {
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

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sumOfLeftLeaves(root.left);// 左
        int rightSum = sumOfLeftLeaves(root.right); // 右

        int sum = 0;
        // 如果左节点不为空，且左节点没有左右孩子，那么这个节点就是左叶子
        if (root.left != null && root.left.left == null && root.left.right == null) {
           sum += root.left.val;
        }

        return sum + leftSum + rightSum;
    }

    public static void main(String[] args) {
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(4, treeNode1, treeNode2);
        TreeNode treeNode5 = new TreeNode(5, treeNode4, treeNode6);
        System.out.print(new Solution404().sumOfLeftLeaves(treeNode5));
    }
}
