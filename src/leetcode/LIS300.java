package leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class LIS300 {
    public int lengthOfLIS_dp(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) dp[i] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && 1 + dp[j] > dp[i]) {
                    dp[i] = 1 + dp[j];
                }
            }
        }
        int max = 1;
        for (int x : dp) if (x > max) max = x;
        return max;
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> arr = new ArrayList<>();
        arr.add(nums[0]);
        for (int i = 1; i < n; i++) {
            if (nums[i] > arr.getLast()) {
                arr.add(nums[i]);
            } else {
                int low = Collections.binarySearch(arr, nums[i]);
                if (low < 0) low = -(low + 1);
                arr.set(low, nums[i]);
            }
        }
        return arr.size();
    }
}
