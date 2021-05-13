package category.greedy.lesson3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0] == 0 ? o1[1] - o2[1] : o2[0] - o1[0]; // 先按身高,身高相同，k 小的排前面
            }
        });

        List<int[]> res = new ArrayList<>();
        for (int[] item : people) { // 再按照k的索引插入
            res.add(item[1], item);
        }
        return res.toArray(new int[0][2]); // 容器转成数组;
    }
}
