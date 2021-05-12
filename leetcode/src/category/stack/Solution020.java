package category.stack;

import java.util.Stack;

public class Solution020 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
//'('，')'，'{'，'}'，'['，']'
        for (char c : s.toCharArray()) {
            if ('(' == c) {
                stack.push(')');
            } else if ('{' == c) {
                stack.push('}');
            } else if ('[' == c) {
                stack.push(']');
            } else {
                if (!stack.isEmpty()) { // 栈不为空
                    char top = stack.pop(); // 栈顶元素和当前元素进行比较
                    if (c != top) {
                        return false;
                    }
                } else { // "}"
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
