package linkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) { // 防呆，判空
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { // 相遇的点
                ListNode begin = head;
                ListNode equal = fast;
                while (begin != equal) { // 这里包含了套圈的情况
                    begin = begin.next;
                    equal = equal.next;
                }
                return begin;
            }
        }
        return null;
    }
}
