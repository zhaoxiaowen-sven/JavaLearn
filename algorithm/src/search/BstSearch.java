package search;

public class BstSearch {

    public static void test() {
        BstTree tree = new BstTree();

        tree.insert(62);
        tree.insert(88);
        tree.insert(58);
        tree.insert(47);
        tree.insert(35);
        tree.insert(73);
        tree.insert(51);
        tree.insert(99);
        tree.insert(37);
        tree.insert(93);
        //        62
        //      /    \
        //     58    88
        //     / \   / \
        //    47     73 99
        //    / \      /
        //   35  51   93
        //    \
        //     37

        System.out.println(tree.search(47));
        System.out.println(tree.search(52));

//        System.out.println("\n前序遍历结果");
//        category.tree.preOrder(category.tree.root);
        System.out.println("\n中序遍历结果");
        tree.midOrder(tree.root);
//        System.out.println("\n后序遍历结果");
//        category.tree.postOrder(category.tree.root);

        tree.delete(tree.root, 58);
        System.out.println("\n中序遍历结果");
        tree.midOrder(tree.root);
    }

    static class TreeNode {
        public int data;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    static class BstTree {
        private TreeNode root;

        public TreeNode search(int data) {
            return search(root, data);
        }

        private TreeNode search(TreeNode currentNode, int data) {
            if (currentNode == null || currentNode.data == data) {
                return currentNode;
            } else if (data < currentNode.data) {
                return search(currentNode.left, data);
            } else {
                return search(currentNode.right, data);
            }
        }

        public void insert(int data) {
            root = insert(root, data);
        }

        private TreeNode insert(TreeNode rootNode, int data) {
            if (null == rootNode) {
                return new TreeNode(data);
            }
            if (data < rootNode.data) {
                rootNode.left = insert(rootNode.left, data);
            }
            if (data > rootNode.data) {
                rootNode.right = insert(rootNode.right, data);
            }
            return rootNode;
        }

        private TreeNode delete(TreeNode treeNode, int data) {
            if (treeNode == null) {
                return null;
            }
            if (data < treeNode.data) {
                // 递归赋值的过程
                treeNode.left = delete(treeNode.left, data);
            } else if (data > treeNode.data) {
                treeNode.right = delete(treeNode.right, data);
            } else {
                if (treeNode.left == null) {
                    return treeNode.right;
                }
                if (treeNode.right == null) {
                    return treeNode.left;
                }
                // 找到节点右子树的最小值，后继节点
                TreeNode minNode = minRightNode(treeNode.right);
                // 用后继节点替换删除节点
                treeNode.data = minNode.data;
                // 将后继节点删除
                treeNode.right = delete(minNode, minNode.data);

                // 第二种方式
//                TreeNode maxNode = maxLeftNode(treeNode.left);
//                treeNode.data = maxNode.data;
//                treeNode.left = delete(maxNode, maxNode.data);
            }
            return treeNode;
        }

        // 左子树的最大值
        private TreeNode maxLeftNode(TreeNode node) {
            while (node.right != null) {
                node = node.right;
            }
            return node;
        }

        // 右子树的最小值
        private TreeNode minRightNode(TreeNode targetNode) {
            while (targetNode.left != null) {
                targetNode = targetNode.left;
            }
            return targetNode;
        }

        public void preOrder(TreeNode treeNode) {
            if (null != treeNode) {
                System.out.print(treeNode.data + ",");
                preOrder(treeNode.left);
                preOrder(treeNode.right);
            }
        }

        public void midOrder(TreeNode treeNode) {
            if (null != treeNode) {
                midOrder(treeNode.left);
                System.out.print(treeNode.data + ",");
                midOrder(treeNode.right);
            }
        }

        public void postOrder(TreeNode treeNode) {
            if (null != treeNode) {
                postOrder(treeNode.left);
                postOrder(treeNode.right);
                System.out.print(treeNode.data + ",");
            }
        }
    }
}


