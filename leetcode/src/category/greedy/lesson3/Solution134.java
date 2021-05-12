package category.greedy.lesson3;

public class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSum = 0;
        int curSum = 0;
        int start = 0;
        int n = gas.length;
        for (int i = 0; i<n;i++) {
            totalSum += gas[i] - cost[i];
           // 每个加油站的剩余量rest[i]为gas[i] - cost[i]。
            //i从0开始累加rest[i]，和记为curSum，一旦curSum小于零，
            // 说明[0, i]区间都不能作为起始位置，起始位置从i+1算起，再从0计算curSum。
            curSum += gas[i] - cost[i];
            if (curSum < 0) {   // 当前累加rest[i]和 curSum一旦小于0
                start = i + 1;  // 起始位置更新为i+1
                curSum = 0;     // curSum从0开始重新加
            }
        }
        // 首先如果总油量减去总消耗大于等于零那么一定可以跑完一圈，否则，不能
        if (totalSum <0) {
            return -1;
        }
        return start;
    }
}
