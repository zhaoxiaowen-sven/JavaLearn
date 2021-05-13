package category.greedy.lesson2;

public class Solution045 {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        int ans = 0;
        int curDistance = 0;
        int nextDistance = 0;
        for (int i = 0; i < n; i++) {
            nextDistance = Math.max(nums[i] + i, nextDistance);  // 更新下一步能覆盖最远距离下标
            if (i == curDistance) {                             // 遇到当前覆盖最远距离下标
                //if (curDistance != n - 1) {                      // 用于判断第一步的情况，貌似这个条件是多余的
                ans++;                                      // 需要走下一步，
                curDistance = nextDistance;                  // 更新当前覆盖最远距离下标（相当于加油了）
                // 这里为什么不是n - i 而是 n-1，因为nexdDistance = nums[i] + i，已经包含了 i。
                //if (nextDistance >= n - 1) break;           // 下一步的覆盖范围已经可以达到终点，结束循环
                if (curDistance >= n - 1) break;           // 改成curDistance
                //} else break;                                     // 当前更好理解覆盖最远距离下标是集合终点，不用做ans++操作了，直接结束
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution045().jump(new int[]{2, 3, 1, 1, 4}));
    }
}
