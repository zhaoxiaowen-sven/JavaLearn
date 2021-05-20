package category.dp.houserob;

import java.util.HashMap;

public class Solution198 {
    public int rob(int[] nums) {
        int n = nums.length;
        // dp[i]：考虑下标i（包括i）以内的房屋，最多可以偷窃的金额为dp[i]。
        int[] dp = new int[n];
        //dp[i] = Max(dp[i - 1], nums[i] + dp[i -2])
        // 如果不偷第i房间，那么dp[i] = dp[i - 1]，即考虑i-1房，（注意这里是考虑，并不是一定要偷i-1房，这是很多同学容易混淆的点）
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[n - 1];
    }

    public int robII(int[] nums) {
        int rob1 = robII(nums, 0, nums.length - 2);
        int rob2 = robII(nums, 1, nums.length - 1);
        return Math.max(rob1, rob2);
    }

    // Solution213
    public int robII(int[] nums, int start, int end) {
        //         //dp[i] = Max(dp[i - 1], nums[i] + dp[i -2])
        int n = nums.length;
        int[] dp = new int[n];
        //dp[i] = Max(dp[i - 1], nums[i] + dp[i -2])
        dp[start] = nums[start];
        dp[start + 1] = Math.max(dp[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[end];
    }


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

    // Solution337
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 抢劫root 节点的最大值
        int sum1 = root.val;
        if (root.left != null) {
            sum1 += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            sum1 += rob(root.right.left) + rob(root.right.right);
        }

        // 抢劫root 节点的最大值
        int sum2 = rob(root.left) + rob(root.right);
        return Math.max(sum1, sum2);
    }

    HashMap<TreeNode, Integer> res = new HashMap<>();

    public int robIII2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (res.containsKey(root)) {
            return res.get(root);
        }

        // 抢劫root 节点的最大值
        int sum1 = root.val;
        if (root.left != null) {
            sum1 += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            sum1 += rob(root.right.left) + rob(root.right.right);
        }

        // 不抢劫root 节点的最大值
        int sum2 = rob(root.left) + rob(root.right);

        int ret = Math.max(sum1, sum2);
        res.put(root, ret);
        return ret;
    }

    public int robIII3(TreeNode root) {
        int[] res = dp(root);
        return Math.max(res[0], res[1]);
    }

    /* 返回一个大小为 2 的数组 arr
    arr[0] 表示不抢 root 的话，得到的最大钱数
    arr[1] 表示抢 root 的话，得到的最大钱数 */
    int[] dp(TreeNode root) {
        if (root == null)
            return new int[]{0, 0};
        int[] left = dp(root.left);
        int[] right = dp(root.right);
        // 抢，下家就不能抢了
        int rob = root.val + left[0] + right[0];
        // 不抢，下家可抢可不抢，取决于收益大小
        int not_rob = Math.max(left[0], left[1])
                + Math.max(right[0], right[1]);

        return new int[]{not_rob, rob};
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(new Solution198().rob(nums));

        System.out.println(new Solution198().robII(nums));
    }
}
