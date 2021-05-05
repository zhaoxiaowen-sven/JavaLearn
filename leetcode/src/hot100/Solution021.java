package hot100;

public class Solution021 {
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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode currentNode = null;
        ListNode before = dummyNode;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? Integer.MAX_VALUE : l1.val;
            int val2 = l2 == null ? Integer.MAX_VALUE : l2.val;

            if (val1 < val2) {
                currentNode = new ListNode(val1);
                l1 = l1 == null ? null : l1.next;
            } else {
                currentNode = new ListNode(val2);
                l2 = l2 == null ? null : l2.next;
            }
            before.next= currentNode;
            before = currentNode;
        }

        return dummyNode.next;
    }
}
