package category.greedy.lesson1;

import java.util.Arrays;

public class Solution455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        // 大胃口吃到大饼干
        int gSize = g.length; // 胃口
        int sSize = s.length; // 饼干
        int index = sSize - 1; // 饼干倒叙
        int result = 0;
        for (int i = gSize - 1; i >= 0; i--) {
            if (index >= 0 && s[index] >= g[i]) { // 满足的情况下，找前一个饼干
                index--;
                result++;
            }
        }
        return result;


        // 用小饼干喂饱小胃口
//        int count = 0;
//        for (int i = 0; i < sSize; i++) {
//            if (count < gSize && s[i] >= g[count]) { // 满足的情况下找下一个胃口
//                count ++;
//            }
//        }
//        return count;
    }

    public static void main(String[] args) {
        new Solution455().findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1});
    }
}
