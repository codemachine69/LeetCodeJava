package leetcode;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal94 {
    List<Integer> res;

    public List<Integer> inorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        inorder(root);
        return res;
    }

    void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
    }
}
