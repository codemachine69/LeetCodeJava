package leetcode;

public class KthSmallestBST230 {
    int count;
    int number = -1;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        return number;
    }

    void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        count--;
        if (count == 0) number = root.val;
        inorder(root.right);
    }

}
