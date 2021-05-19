package category.dp.backpackall;

import category.dp.backpack01.DpUtils;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution377 {

    public int combinationSum41(int[] nums, int target) {

        // int[] nums = {1, 2, 3};
        // dp[j] = dp[j] + dp[j - nums[i - 1]]
        // 组合问题
        // i = 1, nums[0] = 1
        // j = 1 , dp[1] = dp[1] + dp[1-1] = 1
        // j = 2,  dp[2] = dp[2] + dp[2-1] = 1
        // j = 3,  dp[3] = dp[3] + dp[3-1] = 1
        // j = 4,  dp[4] = dp[4] + dp[4-1] = 1
        // [1,1,1,1,1]
        // i = 2, nums[i - 1] = nums[1] = 2
        // j = 1 , j - nums[i - 1] = -1 <= 0 跳过
        // j = 2,  dp[2] = dp[2] + dp[2-2] = 2
        // j = 3,  dp[3] = dp[3] + dp[3-2] = 2
        // j = 4,  dp[4] = dp[4] + dp[4-2] = 3
        // [1,1,2,2,3]
        // i = 3, nums[i - 1] = nums[2] = 3
        // j = 1 , j - nums[i - 1] = -1 <= 0跳过
        // j = 2,  跳过
        // j = 3,  dp[3] = dp[3] + dp[3-3] = 3
        // j = 4,  dp[4] = dp[4] + dp[4-3] = 4
        // [1,1,2,3,4]
//        int n = nums.length;
//        int[] dp = new int[target + 1];
//        dp[0] = 1;
//        for (int i = 1; i <= n; i++) { // 必须要先遍历背包
//            for (int j = 1; j <= target; j++) {
//                if (j - nums[i - 1] >= 0) {
//                    dp[j] = dp[j] + dp[j - nums[i - 1]];
//                }
//            }
//            // DpUtils.dump(dp);
//        }
//        return dp[target];

        // 排列问题
        //  dp[j] = dp[j] + dp[j - nums[i - 1]]
        // j= 1
        // i = 1, dp[1] = dp[1] + dp[1-nums[0]] = dp[1] + dp[0] = 1
        // i = 2, dp[1] = dp[1] + dp[1-nums[1]=-1<=0], 跳过；同理3也跳过 dp[j] = 1;
        // dp [1, 1, 0, 0, 0]
        // j = 2
        // i = 1, dp[2] = dp[2] + dp[2-nums[0]] = dp[2] + dp[1] = 1, dp[2]更新了
        // i = 2, dp[2] = dp[2] + dp[2-nums[1]] = dp[2] + dp[0] = 2
        // i = 3, dp[2] = dp[2] + dp[2-nums[3] == -3] = /
        // dp [1, 1, 2, 2, 0]
        // j = 3
        // i = 1, dp[3] = dp[3] + dp[3-nums[0]] = dp[3] + dp[2] = 2
        // i = 2, dp[3] = dp[3] + dp[3-nums[1]] = dp[3] + dp[1] = 3
        // i = 3, dp[3] = dp[3] + dp[3-nums[2]] = dp[3] + dp[0] = 4
        // dp [1, 1, 2, 4, 0]
        // j = 4
        // i = 1, dp[4] = dp[4] + dp[4-nums[0]] = dp[4] + dp[3] = 4
        // i = 2, dp[4] = dp[4] + dp[4-nums[1]] = dp[4] + dp[2] = 6
        // i = 3, dp[4] = dp[4] + dp[4-nums[2]] = dp[4] + dp[1] = 7
        // dp [1, 1, 2, 4, 7]
        // 以上的过程 容量一直 ++；
        int n = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 1; j <= target; j++) {
            for (int i = 1; i <= n; i++) { // 必须要先遍历背包
                if (j - nums[i - 1] >= 0) {
                    dp[j] = dp[j] + dp[j - nums[i - 1]];
                }
            }
            DpUtils.dump(dp);
        }
        return dp[target];
    }


    int result = 0;

    public int combinationSum4(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();
        dfs(nums, target, nums.length, path, res);
        return result;
    }

    private void dfs(int[] nums, int target, int length, Deque<Integer> path, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result++;
            System.out.println(path);
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < length; i++) {
            path.addLast(nums[i]);
            dfs(nums, target - nums[i], length, path, res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
//        System.out.println(new Solution377().combinationSum4(nums, 4));
        System.out.println(new Solution377().combinationSum41(nums, 4));
    }
}
