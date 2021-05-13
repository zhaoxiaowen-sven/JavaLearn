package category.greedy.lesson4;

import java.util.Arrays;
import java.util.Comparator;

public class Solution435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 按结尾index排序,
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
                /*== 0 ? o2[0] - o1[0] : o1[1] - o2[1]
                * 左边界不需要考虑
                * */
            }
        });
        // [1,2] [2,3] [1,3] [3,4]

        int n = intervals.length;
        int count = 1;
        int end = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] > end) { // 必须要用大于
                count++; // 记录非交叉区间的个数
                end = intervals[i][1];                // 由于是按照结尾排序，所以这里的end
            }
        }
        return n - count;
    }

    public static void main(String[] args) {
//        int[][] arr = {{1, 100},
//                {11, 22},
//                {1, 11},
//                {2, 22}
//        };
//
//
//        new Solution435().eraseOverlapIntervals(arr);
        int[][] arr2 = {{1, 2},
                {2, 3},
                {3, 4},
                {1, 3}
        };
        new Solution435().eraseOverlapIntervals(arr2);
    }
}
