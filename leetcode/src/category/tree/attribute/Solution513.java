package category.tree.attribute;

import java.util.LinkedList;
import java.util.Queue;

public class Solution513 {

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

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        // 1.初始化
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);

        // 2.开始遍历
        while (!nodeQueue.isEmpty()) {
            // 当前层拥有的节点个数
            int count = nodeQueue.size();

            //3. 遍历每一层的节点
            for (int i = 0; i < count; i++) {
                TreeNode node = nodeQueue.poll();
                if (i == 0) {
                    ans = node.val;
                }
                if (node.left != null) { // 顺序添加左右节点
                    nodeQueue.offer(node.left);
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                }
                count--;
            }
        }
        return ans;
    }
}
