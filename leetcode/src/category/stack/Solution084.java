package category.stack;

import java.util.Deque;
import java.util.LinkedList;

public class Solution084 {


    public static void main(String[] args) {
        //int[] nums = new int[]{2,1,5,6,2,3};
        int[] nums = new int[]{2,2,2};
        System.out.println(new Solution084().largestRectangleArea(nums));
    }


    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] h = new int[n + 2];

        for (int i = 0; i < n; i++) {
            h[i + 1] = heights[i];
        }

        int max = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < h.length;i++) {
            int top = stack.peek();
            if (h[i] > h[top]) {
                stack.push(i);
            } else if (h[i] == h[top]) {
               // stack.pop();
                stack.push(i);
            } else {
                while (!stack.isEmpty() &&h[stack.peek()] >  h[i]) {
//                    int mid = stack.peek();
//                    stack.pop();
//                    int w = i - stack.peek() - 1;
//                    int h1 = h[mid];
//                    max = Math.max(max, w * h1);
                    int left = stack.pop();
                    int h1 = h[left];

                    int w = i - left;
                    int w2 = i - stack.peek() - 1;
                    System.out.println(i + ", w = " + w+ ", w2 = " + w2);
                    max = Math.max(max, w * h1);
                }
                stack.push(i);
            }
        }
        return max;
    }
}
