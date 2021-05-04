package stack;

import java.util.Stack;

public class Solution1047 {
    public String removeDuplicates(String S) {
        Stack<Character> st = new Stack<>();
        int n = S.length();
        for (int i = 0; i < n; i++) {
            if (!st.isEmpty() && st.peek() == S.charAt(i)) {
                st.pop();
            } else {
                st.push(S.charAt(i));
            }
        }

        n = st.size();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            s.append(st.get(i));
        }

        return s.toString();
//        int n = S.length();
//        for (int i = 0; i < n; i++) {
//            if (!st.empty() && S.charAt(i) == st.peek()) {
//                st.pop();
//            } else {
//                st.add(S.charAt(i));
//            }
//        }
//        StringBuilder res = new StringBuilder();
//        for (Character c : st) {
//            res.append(c);
//        }
//        return res.toString();
    }
}
