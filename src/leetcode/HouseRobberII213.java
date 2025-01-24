package leetcode;

public class HouseRobberII213 {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(solve(nums, 0, nums.length-2), solve(nums, 1, nums.length-1));
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
