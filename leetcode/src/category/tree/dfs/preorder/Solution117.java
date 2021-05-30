package category.tree.dfs.preorder;

public class Solution117 {
    // Definition for a Node.
    static class Node {
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

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
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
//        System.out.println(root.val);

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


    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }
        connectTwoNode(root.left, root.right);
        return root;
    }

    // FIXME: 2021/5/29 有问题 ！！！！
    private void connectTwoNode(Node left, Node right) {
        if (left == null || right == null) {
            return;
        }
        left.next = right;

        Node lLeft = left.left;
        Node lRight = left.right;

        Node rLeft = right.left;
        Node rRight = right.right;
        if (lLeft != null && lRight != null) {
            connectTwoNode(lLeft, lRight);
        }
        if (rLeft != null && rRight != null) {
            connectTwoNode(rLeft, rRight);
        }

        Node leftNullNode = lRight != null ? lRight : lLeft;
        Node rightNullNode = rLeft != null ? rLeft : rRight;
        connectTwoNode(leftNullNode, rightNullNode);
    }

    public static void main(String[] args) {
        Node Node5 = new Node(5);
        Node Node1 = new Node(1);
        Node Node10 = new Node(10, Node5, Node1);
        Node Node2 = new Node(2, Node10, null);

        Node Node6 = new Node(6);
        Node Node3 = new Node(3, null, Node6);

        Node Node8 = new Node(8);
        Node Node100 = new Node(100, null, Node8);

        Node Node4 = new Node(4, Node3, Node100);
        Node Node0 = new Node(0, Node2, Node4);

        new Solution117().connect2(Node0);
        Node res = Node5;
        StringBuilder stringBuilder = new StringBuilder();
        while (res != null) {
            stringBuilder.append(res.val).append(",");
            res = res.next;
        }
        System.out.println(stringBuilder.toString());
    }

}
