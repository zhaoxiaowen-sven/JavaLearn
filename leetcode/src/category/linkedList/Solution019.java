package category.linkedList;

public class Solution019 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode virtualNode = new ListNode(-1, head);
        ListNode fastPointer = virtualNode;
        ListNode slowPointer = virtualNode;
        while (n-- >=0) {
            //fast首先走n + 1步 ，为什么是n+1呢，
            // 因为只有这样同时移动的时候slow才能指向删除节点的上一个节点（方便做删除操作），
            fastPointer = fastPointer.next;
            System.out.println("n = " + n);
        }
        int i = 1;
        while (fastPointer != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
            System.out.println("i="+i ++);

        }
        slowPointer.next = slowPointer.next.next;
        return virtualNode.next;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);


        new Solution019().removeNthFromEnd(node1, 2);
    }


}
