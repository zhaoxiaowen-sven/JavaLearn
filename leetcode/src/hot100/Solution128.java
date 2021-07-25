package hot100;

import java.util.HashSet;

public class Solution128 {


    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int res = 0;
        for (int num : nums) {
           if (set.contains(num - 1)) {
               continue;
           }
           int cur = 0;
           while (set.contains(num)) {
               num++;
               cur ++;
           }
           res = Math.max(cur, res);
        }
        return res;

        // Set<Integer> numsSet = new HashSet<>();
        // for (Integer num : nums) {
        //     numsSet.add(num);
        // }
        // int longest = 0;
        // for (Integer num : nums) {
        //     if (numsSet.remove(num)) {
        //         // 向当前元素的左边搜索,eg: 当前为100, 搜索：99，98，97,...
        //         int currentLongest = 1;
        //         int current = num;
        //         while (numsSet.remove(current - 1)) current--;
        //         currentLongest += (num - current);
        // // 向当前元素的右边搜索,eg: 当前为100, 搜索：101，102，103,...
        //         current = num;
        //         while(numsSet.remove(current + 1)) current++;
        //         currentLongest += (current - num);
        // 	// 搜索完后更新longest.
        //         longest = Math.max(longest, currentLongest);
        //     }
        // }
        // return longest;
    }

    public static void main(String[] args) {
//        int nums = {0,3,7,2,5,8,4,6,0,1]}
//       new Solution128().longestConsecutive(nums);
    }
}
