package leetcode;

import java.util.HashMap;

public class CountGoodNodesBT1448 {
    int count;

    public int goodNodes(TreeNode root) {
        count = 0;
        helper(root, root.val);
        return count;
    }

    void helper(TreeNode root, int curMax) {
        if (root == null) return;

        if (root.val >= curMax) {
            count++;
            curMax = root.val;
        }

        helper(root.left, curMax);
        helper(root.right, curMax);
    }
}
