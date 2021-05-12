package category.linkedList;

public class Solution206 {
    public class ListNode {
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

    public ListNode reverseList(ListNode head) {
        ListNode preNode = null;
        ListNode current = head;
        while (current != null) {
            ListNode after = current.next;
            current.next = preNode;
            preNode = current;
            current = after;
        }
        return preNode;
        // 返回的时pre，因为如果到了最后一个节点，
        // current.next == null, pre== current,pre 就是最后一个节点了
    }
}
