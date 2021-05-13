package category.greedy.lesson4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution056 {
    public int[][] merge(int[][] intervals) {

        // 合并区间的必须要先固定一个极大值或者极小值
        // 固定极小值后，从低到高搜索
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0] ;
            }
        });

        List<int[]> res = new ArrayList<>();
        int n = intervals.length;
        // start 一定这次搜索范围内最小的
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] > end) { // 边界不重合时, 当前的左 > 上一个右，
                res.add(new int[]{start, end});
                start = intervals[i][0]; // 更新新边界
                end = intervals[i][1]; // 更新新边界
            } else {
                end = Math.max(end, intervals[i][1]); // 边界重合时，扩大右边界
            }
        }
        // 收集最后一次的结果
        res.add(new int[]{start, end});
        return res.toArray(new int[0][2]);
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,3},{2,6},{8,10},{15,18}
        };

        int[][] arr2 = {
                {1,3},{2,6},{5,10}
        };


        int[][] arr3 = {
                {2,3},{4,5},{6,7}, {1,10}
        };

        new Solution056().merge(arr3);
    }
}
