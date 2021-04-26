package hot100;

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

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode current = null;
        ListNode dummyNode = new ListNode(-1); // 标记节点
        int added = 0;
        ListNode p = l1;
        ListNode q = l2;
        while(p != null || q != null) { // 补位
            int val1 = p == null ? 0 : p.val;
            int val2 = q == null ? 0 : q.val;

            int sum = val1 + val2 + added;
            ListNode newNode = new ListNode(sum % 10);
            if(current == null) {
                current = newNode;
                dummyNode.next = newNode;
            } else {
                current.next = newNode;
                current = current.next;
            }


            added = sum / 10;
            p = p == null ? null : p.next; // !!!! 补位
            q = q == null ? null : q.next; //
        }

        if(added > 0 ) {
            current.next = new ListNode(added);
        }

        return dummyNode.next;

    }

    public static void main(String[] args) {
        ListNode l3 = new ListNode(3);
        ListNode l2 = new ListNode(4, l3);
        ListNode l1 = new ListNode(2, l2);

        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(6, l4);
        ListNode l6 = new ListNode(5, l5);
        ListNode listNode = new Solution002().addTwoNumbers(l1, l6);
        while (listNode != null) {
            System.out.print("val = " + listNode.val);
            listNode = listNode.next;
        }
    }
}
