package leetcode;

public class JumpGame55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int last = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] + i >= last) last = i;
        }
        return last <= 0;
    }
}
