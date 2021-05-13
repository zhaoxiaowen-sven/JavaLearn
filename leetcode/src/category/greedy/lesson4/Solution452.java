package category.greedy.lesson4;

import java.util.Arrays;
import java.util.Comparator;

public class Solution452 {
    public int findMinArrowShots(int[][] points) {
        // 将区间按照右边界从小到大排
        // 最近新增了Test Case， [[-2147483646,-2147483645],[2147483646,2147483647]] 就过不了了，
        // 这是因为差值过大而产生溢出。sort的时候不要用a-b来比较，要用Integer.compare(a, b)!!!
//        Arrays.sort(points, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return Integer.compare(o1[1], o2[1]);
//            }
//        });
//        int n = points.length;
//        int count = 1;
//        int end = points[0][1];
//        for (int i = 1; i < n; i++) {
//            if (end < points[i][0]) { // 右边界小于下一个左边界，又需要一支箭
//                count++;
//                end = points[i][1]; // 更新右区间值
//            }
//        }
//        return count;

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        int n = points.length;
        int count = 1;
        int end = points[0][1];
        for (int i = 1; i < n; i++) {
            if (points[i][0] > end) { // 右边界小于下一个左边界，又需要一支箭
                count++;
                end = points[i][1]; // 更新新的右边界
            } else {
                end = Math.min(points[i][1], end); // 取2个区间中最小的右区间
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] points = {
                {10,16},{2,8},{1,6},{7,12}
        } ;
        new Solution452().findMinArrowShots(points);
    }
}
