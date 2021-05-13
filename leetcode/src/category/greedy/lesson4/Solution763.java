package category.greedy.lesson4;

import java.util.ArrayList;
import java.util.List;

public class Solution763 {
    
    // 这是一道map题
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int n = s.length();
        int[] arr = new int[n];
        // 记录字符串中每个字符 出现的最晚位置
        // <c, count>
        for (int i = 0; i < n; i++) {
            arr[s.charAt(i) - 'a'] = i;
        }

        int left = 0;
        int right = 0;
        for (int i = 0; i < n; i++) {
            right = Math.max(right, arr[s.charAt(i) - 'a']); // 找到字符出现的最远边界
            if (i == right) { // 找到已出现字符的最右边界
                res.add(right - left + 1);// 找出的区间是闭区间 []
                left = right + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution763().partitionLabels("ababcbacadefegdehijhklij");
    }
}
