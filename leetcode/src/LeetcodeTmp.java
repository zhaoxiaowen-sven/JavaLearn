import java.util.*;

public class LeetcodeTmp {

    public static void main(String[] args) {
//        char[] c = new char[]{'A','A','A','B','B'};
//        System.out.println(leastInterval(c, 2));

//        String s = "s";
//        int[] num1 = {1,2,3, 0,0,0};
//        int[] num2 = {2,5,6};
//        merge(num1,3,num2,3);
//        int[] num3 = {2, 3, -2, 4};
//        maxProduct(num3);
//        int[] num4 = {1, 2, 3, 4, 5};
//        rotate(num4, 2);
//
//        int[] num5 = {7, 2, 4};
//        maxSlidingWindow(num5, 2);
//
//        String[] s = {"2", "1", "+", "3", "*"};
//        int[][] mt = new int[][]{{1, 5, 9}, {6, 11, 13}, {12, 13, 15}};
//        kthSmallest(mt, 3);

      //  ListNode node3 = new ListNode(3);
       // ListNode node1 = new ListNode(1, node3);
        ListNode node2 = new ListNode(2);
        ListNode node4 = new ListNode(4, node2);

        sortList(node4);
    }


    //Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return sortList(head, null);
    }

    private static ListNode sortList(ListNode low, ListNode high) {
        if (low == high) {
            return low;
        }

        ListNode fast = low;
        ListNode slow = low;
        while (fast != high && fast.next != high) {
            fast = fast.next.next;
            slow = slow.next;
        }
        System.out.println("slow = " + slow.val);
        // slow 4 2 null ,null
        // 2
        ListNode l1 = sortList(slow.next, high);
        slow.next = null;
        // start 4 end 2
        // 4
        ListNode l2 = sortList(low, slow);

        return merge(l1, l2);
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if (l1 != null) {
            cur.next = l1;
        }

        if (l2 != null) {
            cur.next = l2;
        }
        return dummy.next;
    }

    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            queue.add(new int[]{matrix[0][i], 0, i});
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
            int dx = queue.peek()[1];
            int dy = queue.peek()[2];
            res = queue.poll()[0];
            if (dx < n - 1) {
                queue.offer(new int[]{matrix[dx + 1][dy], dx + 1, dy});
            }
        }
        return res;
    }

    private static boolean isOpe(String s) {
        return s.length() == 1 && s.charAt(0) < '0' || s.charAt(0) > '9';
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && queue.peekLast() <= nums[i]) {
                queue.removeLast();
            }
            queue.addLast(nums[i]);
        }
        int index = 0;
        int[] ans = new int[nums.length - k + 1];
        ans[index++] = queue.peekFirst();

        for (int i = k; i < nums.length; i++) {
            //
            while (!queue.isEmpty() && queue.peekLast() <= nums[i]) {
                queue.removeLast();
            }
            queue.addLast(nums[i]);
            while (!queue.isEmpty() && i - k + 1 > k) {
                queue.removeFirst();
            }
            ans[index++] = queue.peekFirst();
        }
        return ans;
    }

    public static void rotate(int[] nums, int k) {
        int len = nums.length, n = len;
        int i = 0, pos = 0, pre = nums[pos], temp = nums[pos];

        if (k % n == 0) return;

        while (n-- != 0) {
            pos = (pos + k) % len;
            temp = nums[pos];
            nums[pos] = pre;
            pre = temp;
            if (pos == i) {
                pos = ++i;
                pre = nums[pos];
                temp = nums[pos];
            }
        }
    }

    public static int leastInterval(char[] tasks, int n) {
        int len = 5;
        int[] buckets = new int[len];
        for (int i = 0; i < tasks.length; i++) {
            buckets[tasks[i] - 'A']++;
        }
        Arrays.sort(buckets);

        int maxTimes = buckets[len - 1] - 1;
        int space = maxTimes * n;

        for (int i = len - 2; i >= 0 && buckets[i] > 0; i--) {
            space -= Math.min(maxTimes, buckets[i]);
        }
        return space > 0 ? tasks.length + space : tasks.length;
    }

    public static int maxProduct(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int res = nums[0];
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] < 0) {
                int tmp = max;
                max = min;
                min = tmp;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);

            res = Math.max(max, res);
        }
        return res;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int end = m + n - 1;
        // end = 3
        //1 2 3.  i =
        //2 5 6
        while (i >= 0 || j >= 0) {
            if (i == -1) {
                nums1[end--] = nums2[j--];
            } else if (j == -1) {
                nums1[end--] = nums1[i--];
            } else {
                if (nums1[i] <= nums2[j]) {
                    nums1[end] = nums2[j];
                    end--;
                    j--;
                } else {
                    nums1[end] = nums1[i];
                    end--;
                    i--;
                }
            }
        }
    }

    public static String decodeString(String s) {
        int times = 0;
        Deque<Integer> nums = new LinkedList<>();
        Deque<String> previousS = new LinkedList<>();

        String res = "";

        for (char c : s.toCharArray()) {
            if (c == '[') {
                // 遇到左括号入栈
                nums.push(times);
                previousS.push(res);
                times = 0;
                res = "";
            } else if (c == ']') {
                int curTimes = nums.pop();
                String preS = previousS.pop();
                StringBuilder tmp = new StringBuilder();
                for (int i = 0; i < curTimes; i++) {
                    tmp.append(res);
                }
                res = preS + tmp.toString();
                previousS.push(res);
            } else if (c >= '0' && c <= '9') {
                //遇到数字是 > 9 的情况
                times = times * 10 + Integer.parseInt(c + "");
            } else {
                // 字母的情况
                res += c;
            }
        }
        return res;
    }

    public static int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        int ans = 0;
        Deque<Integer> st = new LinkedList<>();
        st.push(0);
        for (int i = 1; i < height.length; i++) {
            if (height[st.peek()] >= height[i]) {
                st.push(i);
            } else {
                while (!st.isEmpty() && height[st.peek()] < height[i]) {
                    int mid = st.pop();
                    if (!st.isEmpty()) {
                        int left = st.peek();
                        int h1 = Math.min(height[i], height[left]) - height[mid];
                        ans += h1 * (i - left - 1);
                    }
                }
                st.push(i);
            }
        }
        return ans;
    }

    public static int findUnsortedSubarray(int[] nums) {
        int len = nums.length - 1;
        // left之后的都比它大，// right之前的都比它小
        int left = 0, right = len - 1;
        int max = nums[0], min = nums[nums.length - 1];
        // ------------->
        //     2 4 1 3 6
        //max  2 4     6
        //left     2 3
        // <-------------
        // min           1 3 6
        // right   0  0
        for (int i = 0; i < nums.length; i++) {
            if (max <= nums[i]) {
                max = nums[i];
            } else {
                left = i;
            }
        }
        for (int i = len - 1; i >= 0; i--) {
            if (min >= nums[i]) {
                min = nums[i];
            } else {
                right = i;
            }
        }
        if (left == 0 && right == len - 1) {
            return 0;
        }
        return left - right + 1;
    }


    public static List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int l = 0, r = 0;

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> win = new HashMap<>();

        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();
        int match = 0;
        while (r < n) {
            char c = s.charAt(r);
            if (need.containsKey(c)) {
                int times = win.getOrDefault(c, 0) + 1;
                win.put(c, times);
                if (times == need.get(c)) {
                    match++;
                }
            } else {
                // 需要连续
                win = new HashMap<>();
                match = 0;
                l = r + 1;
            }
            r++;

            while (match == need.size()) {
                if (r - l == p.length()) {
                    res.add(l);
                }
                char c2 = s.charAt(l);
                if (need.containsKey(c2)) {
                    int times2 = win.get(c2) - 1;
                    win.put(c2, times2);
                    if (times2 < need.get(c2)) {
                        match--;
                    }
                }
                l++;
            }
        }
        return res;
    }

    public static void rotate(int[][] matrix) {
        int start = 0;
        int n = matrix.length - 1;
        int gap = n;
//        while (gap > 0) {
        // gap = 2
        int j = 0;
//            for (int j = start; j< start + gap; j++) {
        int temp = matrix[start][start];
        matrix[start][start] = matrix[start + gap][start];

        // z左下角
        matrix[start + gap][start] = matrix[start + gap][start + gap];
        // 右下角
        matrix[start + gap][start + gap] = matrix[start][start + gap];
        // 右上角
        matrix[start][start + gap] = temp;
//            }
//            start += 1;
//            gap -= 2;
//        }
        System.out.println(matrix);
    }
}
