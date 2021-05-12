package category.linkedList;

public class Solution7071 {
     static class MyLinkedList {
        Node head;
        int size;

        class Node {
            int val;
            Node next;

            Node(int val) {
                this.val = val;
            }

            Node(int val, Node next) {
                this.val = val;
                this.next = next;
            }
        }

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {
            head = new Node(-1);
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
         if (index < 0 || index >= size) {
                return -1;
            }
            Node current = head.next;
            while (index-- > 0) {
                current = current.next;
            }
            return current.val;
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            Node newNode = new Node(val, head.next);
            head.next = newNode;
            size++;
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current .next = new Node(val);
            size++;
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            if (index <= 0) {
                addAtHead(val);
            } else if (size == index) {
                addAtTail(val);
            } else {
                Node before = head;
                while (index-- > 0) {
                    before = before.next;
                }
                before.next = new Node(val, before.next);
                size ++;
            }
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            Node before = head;
            while (index-- >0) {
                before = before.next;
            }
            before.next = before.next.next;
            size --;
        }

        void print() {
            Node current = head.next;
            while (current != null) {
                System.out.print(current.val + ",");
                current = current.next;
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
//        int param_1 = obj.get(index);
        obj.print();
        obj.addAtHead(1);
        obj.print();
         obj.addAtTail(3);
        obj.print();
        obj.addAtIndex(1,2);
        obj.get(1);
        obj.print();

        obj.deleteAtIndex(1);
        obj.print();
        obj.get(1);
    }
}
