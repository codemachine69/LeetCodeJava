package leetcode;

public class DiameterBinaryTree543 {
    int max;

    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        maxDepth(root);
        return max;
    }

    int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
