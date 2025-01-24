package leetcode;

public class HouseRobber198 {
    public int rob(int[] nums) {
        return solve(nums, 0, nums.length-1);
    }

    private int solve(int[] nums, int start, int end) {
        int a = 0, b = 0;

        for(int i=start; i<=end; i++) {
            int temp = Math.max(nums[i]+a, b);
            a = b;
            b = temp;
        }
        return b;
    }
}
