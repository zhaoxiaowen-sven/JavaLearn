package category.backtrack.tree;

import category.tree.TreeNode;

public class Solution437 {

    /* 等于 == 以root为路径 + 以左为路径 + 以右为路径
        对每个节点，有两种情况：
            1. 在这个节点为根节点的树中找路径，同时以该节点为起始节点
            2. 在这个节点的子树中找。

     // *****相当于每次都从根到子节点的路径******** //
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        // 以当前节点为路径起点，关键之处，以左右又作为新节点
        return dfs(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    public int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (root.val == sum) {
            // 满足一条 ，这里不可以return
            count = 1;
        }
         /*
            因为存在正负数，存在这种案例
            [1,-2,-3,1,3,-2,null,-1] -1
            [1,-2],[1,-2,1,-1]：以根节点为路径的可能不止一条
        */
        // 继续递归左右
        count += dfs(root.left, sum - root.val);
        count += dfs(root.right, sum - root.val);
        return count;
    }
}
