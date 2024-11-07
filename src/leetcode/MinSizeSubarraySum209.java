package leetcode;

public class MinSizeSubarraySum209 {
    public int minSubArrayLen(int target, int[] nums) {
        int minlength = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            sum += nums[right++];

            while (sum >= target) {
                minlength = Integer.min(minlength, right - left);
                sum -= nums[left++];
            }
        }

        return (minlength == Integer.MAX_VALUE) ? 0 : minlength;
    }
}
