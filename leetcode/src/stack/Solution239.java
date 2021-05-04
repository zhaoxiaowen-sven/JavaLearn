package stack;

import java.util.Deque;
import java.util.LinkedList;

public class Solution239 {
//    遍历给定数组中的元素，如果队列不为空且当前考察元素大于等于队尾元素，则将队尾元素移除。
//    直到，队列为空或当前考察元素小于新的队尾元素；
//    当队首元素的下标小于滑动窗口左侧边界left时，表示队首元素已经不再滑动窗口内，因此将其从队首移除。
//    由于数组下标从0开始，因此当窗口右边界right+1大于等于窗口大小k时，意味着窗口形成。此时，队首元素就是该窗口内的最大值。
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

            int left = i - k + 1;
           // 当队首元素的下标小于滑动窗口左侧边界left时，表示队首元素已经不再滑动窗口内，因此将其从队首移除。
            // 4 3 2 1
            if (deque.peekFirst() < left) {
                deque.removeFirst();
            }
            int right = i + 1; // i + 1 ，i+ 1 是size
            if (right >= k) {
                arr[left] = nums[deque.peekFirst()];
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        System.out.println(new Solution239().maxSlidingWindow(nums, 3));
    }
}
