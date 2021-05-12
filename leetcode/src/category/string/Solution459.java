package category.string;

public class Solution459 {

    public static void main(String[] args) {
        System.out.println(new Solution459().repeatedSubstringPattern("ababba"));
    }
    public boolean repeatedSubstringPattern(String s) {
        if(s.length() == 0) {
            return false;
        }

        int len = s.length();
        int[] next = getNext(s);

        if(next[len - 1] != 0 && (len % (len - next[len - 1]) == 0)) {
            return true;
        }
        return false;
    }

    private int[] getNext(String s) {
        int n = s.length();
        int[] next = new int[n];

        int j = 0;
        next[0] = 0;

        for(int i = 1; i<n; i++) {
            while( j > 0 && s.charAt(i) != s.charAt(j)) { // ！=
                j = next[j - 1]; // 回溯到前一位
            }

            if(s.charAt(j) == s.charAt(i)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
