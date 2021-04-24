package linkedList;
/**
 * Definition for singly-linked list.

 */

public class Solution203 {

    public ListNode removeElements(ListNode head, int val) {
//        while (head != null && head.val == val) {
//            head = head.next;
//        }
//        ListNode current = head;
//        while (current != null && current.next != null) {
//            ListNode after = current.next;
//            if (after.val == val){
//                current.next = after.next;
//                after = null;
//            } else {
//                current = current.next;
//            }
//        }
//        return head;

        // 加一个虚节点可以让值在头节点的情况和在值在其他的节点的情况统一
        ListNode virtualHead = new ListNode(-1, head);
        ListNode currentNode = virtualHead;
        while (currentNode.next != null) {
            if (currentNode.next.val == val) {
                ListNode after = currentNode.next;
                currentNode.next = after.next;
                after = null;
            } else {
                currentNode = currentNode.next;
            }
        }
        return virtualHead.next;
    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}


