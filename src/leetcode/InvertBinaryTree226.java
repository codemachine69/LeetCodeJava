package leetcode;

import java.util.Stack;

public class InvertBinaryTree226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root;
    }

    public TreeNode invertTree_stack(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode top = stack.pop();
            TreeNode temp = top.left;
            top.left = top.right;
            top.right = temp;

            if (top.left != null) stack.push(top.left);
            if (top.right != null) stack.push(top.right);
        }
        return root;
    }
}
