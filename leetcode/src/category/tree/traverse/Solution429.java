package category.tree.traverse;

import java.util.*;

public class Solution429 {

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

    ;

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        // 1.初始化
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            List<Integer> level = new ArrayList<>();
            while (size > 0) {
                Node node = nodeQueue.poll();
                level.add(node.val);
                List<Node> childs = node.children;
                if (childs != null && !childs.isEmpty()) {
                    nodeQueue.addAll(childs);
                }
                size--;
            }
            ans.add(level);
        }
        return ans;
    }

}
