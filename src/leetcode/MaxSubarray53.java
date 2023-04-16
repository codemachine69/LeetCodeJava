package leetcode;

public class MaxSubarray53 {
    public int maxSubArray(int[] nums) {
        int maxSub = nums[0];
        int currSum = 0;

        for (int x : nums) {
            if (currSum < 0) currSum = 0;
            currSum += x;
            maxSub = Math.max(maxSub, currSum);
        }
        return maxSub;
    }
}
