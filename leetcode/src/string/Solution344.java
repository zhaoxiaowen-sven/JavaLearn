package string;

public class Solution344 {
    public void reverseString(char[] s) {
        int right = s.length -1;
        int left = 0;
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
}
