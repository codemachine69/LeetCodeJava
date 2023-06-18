package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagTraversal103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        boolean leftToRight = true;
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> level = new ArrayList<>();
            while (level.size() < len) level.add(0);

            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                int idx = leftToRight ? i : len - i - 1;
                level.set(idx, node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            leftToRight = !leftToRight;
            result.add(level);
        }
        return result;
    }
}
