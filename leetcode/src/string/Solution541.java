package string;

public class Solution541 {
    public String reverseStr(String s, int k) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int start = 0;
        int end = 0;

        for (int i = 0; i < len; i += 2 * k) {
            int remain = len - i;
            if (remain < k) { // <k，逆转所有
                start = i ;
                end = len - 1;
            } else  { // > k，都是逆转前k个，区间是前闭后开的 [)
                start = i;
                end = i + k - 1;
            }
            reverse(chars, start, end);
        }
        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        System.out.print(new Solution541().reverseStr("abcdefg" , 8));
    }
}
