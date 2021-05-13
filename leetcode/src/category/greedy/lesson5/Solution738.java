package category.greedy.lesson5;

public class Solution738 {
    public int monotoneIncreasingDigits(int n) {
//        for (int i = n; i > 0; i--) {
//            if (checkNum(i)) return i;
//        }
//        return 0;
        char[] chars = String.valueOf(n).toCharArray();
        int size = chars.length;
        int from = size; // 找到变9的位置，而不是直接赋值为9，否则像100这种特殊情况没法处理
        for (int i = size - 2; i > 0; i--) {
            if (chars[i] > chars[i + 1]) {
                chars[i]--;
                from = i + 1; // 后一位变9，记录的都是索引
            }
        }
        for (int i = from; i < size; i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(new String(chars));
    }

    boolean checkNum(int num) {
        int max = 10;
        while (num > 0) {
            int t = num % 10; // 取最低位
            if (max >= t) {
                max = t; //
            } else {
                return false;
            }
            num = num / 10; //
        }
        return true;
    }

    public static void main(String[] args) {
        new Solution738().monotoneIncreasingDigits(10);
    }
}
