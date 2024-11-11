package leetcode;

import java.util.HashMap;

public class TargetSum494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int x : nums) sum += x;

        if (Math.abs(target) > sum || (sum + target) % 2 != 0) return 0;

        int s1 = (target + sum) / 2;
        return subsetCount(nums, s1);
    }

    private int subsetCount(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n + 1][target + 1];

        for (int i = 1; i <= target; i++) dp[0][i] = 0;
        for (int i = 0; i <= n; i++) dp[i][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i - 1] > j) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
            }
        }
        return dp[n][target];
    }
}
