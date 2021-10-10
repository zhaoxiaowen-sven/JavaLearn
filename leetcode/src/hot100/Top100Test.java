package hot100;

import java.util.Deque;
import java.util.LinkedList;

public class Top100Test {
    public static void main(String[] args) {
//        new Solution001().test();
//        new Solution002().test();
//        new Solution003().test();
//        new Solution004().test();
//        new Solution005().test();
//        new Solution007().test();
//        new Solution008().test();
//        new Solution009().test();
        int[] arr = new int[]{2, 3, 1, 8, 9, 20, 12};
        new Top100Test().find(arr);
    }
    public int[] find(int[] nums) {
        int n = nums.length;
        Deque<Integer> st = new LinkedList<>();
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] > maxNum) {
                st.push(i);
                maxNum = nums[i];
            } else {
                while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                    st.pop();
                }
            }
        }

        String s = "";
        int[] res = new int[st.size()];
        int i = 0;
        while (!st.isEmpty()) {
            res[i++] = st.pop();
        }
        return res;
    }
}
