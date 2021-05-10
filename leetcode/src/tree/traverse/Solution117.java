package tree.traverse;

public class Solution117 {
    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
//        if (root == null) {
//            return null;
//        }
//        // 1.初始化
//        Queue<Node> queue = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            Node nodePre = null;
//            for (int i = 0; i < size; i++) {
//                Node node = queue.poll();
//                if (i == 0) {
//                    nodePre = node;
//                } else {
//                    nodePre.next = node;
//                    nodePre = node;
//                }
//
//                if (node.left != null) {
//                    queue.offer(node.left);
//                }
//                if (node.right != null) {
//                    queue.offer(node.right);
//                }
//            }
//            if (nodePre != null) {
//                nodePre.next = null;
//            }
//        }
//        return root;
        // 1.退出条件
        if (root == null) {
            return null;
        }

        // 递归情况 1
        // 1.子节点有相同的的父节点，有子节点的情况
        //  a
        // / \
        //b  c
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                // 递归情况 2
                //       a
                //     /   \
                //    b ->   c
                //   / \    / \
                //  d      (e)  h
                // 如果是root是b时c， 需要将d (e, f) 建立连接
                root.left.next = getNext(root.next);
            }
        }


        if (root.right != null) {
            root.right.next = getNext(root.next);
        }
        // ！！！！先递归右子树 ！！！
        connect(root.left);
        connect(root.right);
        return root;
    }

    private Node getNext(Node root) {
        if (root == null) return null;
        if (root.left != null) return root.left;
        if (root.right != null) return root.right;
        if (root.next != null) return getNext(root.next);
        return null;
    }
}
