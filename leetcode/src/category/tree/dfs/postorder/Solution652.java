package category.tree.dfs.postorder;

import category.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution652 {
    HashMap<String, Integer> count = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    private String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);
        String path = left + ", " + right + "," + root.val;
        int c = count.getOrDefault(path, 0);
        if (c == 1) {
            res.add(root);
        }
        count.put(path, c + 1);
        return path;
    }
}
