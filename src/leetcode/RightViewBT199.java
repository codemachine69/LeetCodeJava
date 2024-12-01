package leetcode;

import java.util.ArrayList;
import java.util.List;

public class RightViewBT199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        helper(root, ls, 0);
        return ls;
    }

    private void helper(TreeNode node, List<Integer> ls, int level) {
        if (node == null) return;
        if (ls.size() == level) ls.add(node.val);
        helper(node.right, ls, level + 1);
        helper(node.left, ls, level + 1);
    }
}
