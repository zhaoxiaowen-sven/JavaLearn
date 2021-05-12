package category.tree.attribute;

import java.util.List;

//https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/submissions/
public class Solution559 {

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.children != null && !root.children.isEmpty()) { // 子节点不为空的情况
            int max = 0;
            for (Node node : root.children) {
                max = Math.max(max, maxDepth(node));
            }
            return 1 + max;
        }
        // 子节点为空，根节点不为空，返回 1
        return 1;
    }
}
