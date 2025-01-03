package leetcode;

public class NumberOfWaysToSplitArray2270 {
    public int waysToSplitArray(int[] nums) {
        long sum = 0;
        long curSum = 0;
        int splits = 0;
        for (int num : nums) sum += num;

        for (int i = 0; i < nums.length - 1; i++) {
            curSum += nums[i];
            if (curSum >= sum - curSum) splits++;
        }

        return splits;
    }
}
