package top100;

public class Solution002 {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // begin 是头指针 不涉及循环过程中的任何逻辑
        ListNode begin = new ListNode(0);
        ListNode current = begin;
        int carry = 0;
        ListNode p = l1;
        ListNode q = l2;
        while (p != null || q != null) {
            int pVal = p != null ? p.val : 0;
            int qVal = q != null ? q.val : 0;
            int sum = pVal + qVal + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            p = p != null ? p.next : null;
            q = q != null ? q.next : null;
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return begin.next;
    }

    public void test() {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode ret = addTwoNumbers(l1, l2);
        while (ret != null) {
            System.out.print(ret.val + ", ");
            ret = ret.next;
        }
    }
}
