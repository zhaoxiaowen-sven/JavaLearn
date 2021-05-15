package category.tree.attribute;

public class Solution112 {

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

    public boolean hasPathSum(TreeNode root, int targetSum) {
//        if (root == null) {
//            return false;
//        }
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        Queue<Integer> levelCount = new LinkedList<>();
//        queue.offer(root);
//        levelCount.offer(root.val);
//
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            while (size > 0) {
//                TreeNode treeNode = queue.poll();
//                int count = levelCount.poll();
//                if (treeNode.left == null && treeNode.right == null) {
//                    if (count == targetSum) {
//                        return true;
//                    }
//                } else {
//                    if (treeNode.left != null) { // 层序遍历所有路径
//                        queue.offer(treeNode.left);
//                        levelCount.offer(count + treeNode.left.val);
//                    }
//                    if (treeNode.right != null) {
//                        queue.offer(treeNode.right);
//                        levelCount.offer(count + treeNode.right.val);
//                    }
//                }
//                size--;
//            }
//        }
//
//        return false;
        if (root == null) {
            return false;
        }

        return dfs(root, targetSum);
    }

    private boolean dfs(TreeNode root, int targetSum) {
        if (root.left == null && root.right == null) {
            if (targetSum - root.val == 0) {
                return true;
            }
            return false;
        }

        boolean left = false;
        if (root.left != null) {
            left = dfs(root.left, targetSum - root.val);
        }
        if (!left && root.right != null) {
            return dfs(root.right, targetSum - root.val);
        }
        return left;
    }
}
