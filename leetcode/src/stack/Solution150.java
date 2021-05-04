package stack;

import java.util.Deque;
import java.util.LinkedList;

public class Solution150 {

    public int evalRPN(String[] tokens) {
        Deque<String> st = new LinkedList<>();
        for (String s : tokens) {
            if (isToken(s)) {
                int a = Integer.parseInt(st.pop());
                int b = Integer.parseInt(st.pop());
                if (s.equals("+")) {
                    st.push(String.valueOf(a + b));
                } else if (s.equals("-")) {
                    st.push(String.valueOf(b - a));
                } else if (s.equals("*")) {
                    st.push(String.valueOf(b * a));
                } else if (s.equals("/")) {
                    st.push(String.valueOf(b / a));
                }
            } else {
                st.push(s);
            }
        }
        return Integer.parseInt(st.pop());
    }

    private boolean isToken(String token) {
        return "+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token);
    }

    public static void main(String[] args) {
        String[] s = new String[]{"4", "13", "5", "/", "+"};
        String[] s2 = new String[]{"4", "3", "-"};
        System.out.println(new Solution150().evalRPN(s));
        System.out.println(new Solution150().evalRPN(s2));
    }
}