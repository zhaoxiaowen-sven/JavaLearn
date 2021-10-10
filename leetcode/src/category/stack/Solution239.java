package category.stack;

import java.util.Deque;
import java.util.LinkedList;

public class Solution239 {
    //    遍历给定数组中的元素，如果队列不为空且当前考察元素大于等于队尾元素，则将队尾元素移除。
//    直到，队列为空或当前考察元素小于新的队尾元素；
//    当队首元素的下标小于滑动窗口左侧边界left时，表示队首元素已经不再滑动窗口内，因此将其从队首移除。
//    由于数组下标从0开始，因此当窗口右边界right+1大于等于窗口大小k时，意味着窗口形成。此时，队首元素就是该窗口内的最大值。
    //https://leetcode-cn.com/problems/sliding-window-maximum/solution/shuang-xiang-dui-lie-jie-jue-hua-dong-chuang-kou-2/
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        // 1.遍历给定数组中的元素，如果队列不为空且当前考察元素大于等于队尾元素，则将队尾元素移除。
        // 直到，队列为空或当前考察元素小于新的队尾元素；
        for (int i = 0; i < n; i++) { // 为何是小于n 不是小于n -1 原因，窗口的left从0 到 n - k + 1 的
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.removeLast();
            }
            // 记录的是索引
            deque.addLast(i);
            // left 和right 构成窗口，不断右移
            int left = i - k + 1;
            // 当队首元素的下标小于滑动窗口左侧边界left时，表示队首元素已经不再滑动窗口内，因此将其从队首移除。
            // 4 3 2 1
            if (deque.peekFirst() < left) {
                deque.removeFirst();
            }
            int right = i + 1; // i + 1 ，i+ 1 是size
            if (right >= k) { //[left,right]之间差k个元素
                arr[left] = nums[deque.peekFirst()];
            }
        }
        return arr;
    }

    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> st = new LinkedList<>();
        int idx = 0;
        for (int i = 0; i< nums.length; i++) {
            while (!st.isEmpty() && st.peekFirst() < i - k + 1) {
                st.removeFirst();
            }
            while (!st.isEmpty() && nums[st.peekLast()] < nums[i]) {
                st.removeLast();
            }

            st.addLast(i);
            if (i >= k - 1) {
                res[idx++] = nums[st.peekFirst()];
            }
        }
        return  res;
//        for (int i = 0; i < k; i++) {
//            while(!st.isEmpty() && st.peekLast() < nums[i]){
//                st.removeLast();
//            }
//            st.addLast(nums[i]);
//        }
//        int arrIndex = 0;
//        res[arrIndex ++] = st.peekFirst();
//        for(int i = k; i< nums.length; i++) {
//            while(!st.isEmpty() && st.peekLast() < nums[i]) {
//                st.removeLast();
//            }
//            st.addLast(nums[i]);
//            res[arrIndex ++] = st.peekFirst();
//        }
//        return res;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,-1};
        int[] res = new Solution239().maxSlidingWindow2(nums, 1);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : res) {
            stringBuilder.append(i).append(",");
        }
        System.out.println(stringBuilder.toString());
    }
}
