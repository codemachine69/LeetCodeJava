package leetcode;

public class HouseRobber198 {
    public int rob(int[] nums) {
        int n = nums.length;
        int a = 0, b = nums[0], c = 0;
        if (n == 1) return 0;

        for (int i = 2; i <= n; i++) {
            c = Math.max(nums[i - 1] + a, b);
            a = b;
            b = c;
        }

        return c;
    }
}
