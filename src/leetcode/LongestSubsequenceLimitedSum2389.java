package leetcode;

import java.util.Arrays;

public class LongestSubsequenceLimitedSum2389 {
    public int[] answerQueries_bruteforce(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int count = 0, sum = 0;
            for (int x : nums) {
                if (sum + x < queries[i]) {
                    sum += x;
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }

    public int[] answerQueries_bs(int[] nums, int[] queries) {
        int m = queries.length, n = nums.length;
        Arrays.sort(nums);
        int[] ans = new int[m];
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }
        for (int i = 0; i < m; i++) {
            int l = 0, r = n - 1, bound = -1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] <= queries[i]) {
                    bound = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            ans[i] = bound + 1;
        }
        return ans;
    }


}
