package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseOddLevelsOfBinaryTree2415 {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            TreeNode[] currLevel = new TreeNode[size];

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                currLevel[i] = node;

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            if (level % 2 == 1) {
                int left = 0, right = size - 1;
                while (left < right) {
                    int temp = currLevel[left].val;
                    currLevel[left].val = currLevel[right].val;
                    currLevel[right].val = temp;
                    left++;
                    right--;
                }
            }

            level++;
        }

        return root;
    }
}
