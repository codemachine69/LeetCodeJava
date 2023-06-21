package leetcode;

import java.util.ArrayList;
import java.util.List;

public class RightViewBT199 {
    int maxLevel;
    List<Integer> arr;

    public List<Integer> rightSideView(TreeNode root) {
        maxLevel = 0;
        arr = new ArrayList<>();
        helper(root, 1);
        return arr;
    }

    void helper(TreeNode root, int level) {
        if (root == null) return;
        if (level > maxLevel) {
            arr.add(root.val);
            maxLevel = level;
        }
        helper(root.right, level + 1);
        helper(root.left, level + 1);
    }
}
