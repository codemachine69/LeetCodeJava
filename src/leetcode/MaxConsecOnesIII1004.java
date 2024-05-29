package leetcode;

public class MaxConsecOnesIII1004 {
    public int longestOnes(int[] nums, int k) {
        int l = 0, maxWinLen = 0, numZeroes = 0;

        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) numZeroes++;

            while (numZeroes > k) {
                if (nums[l] == 0) numZeroes--;
                l++;
            }

            maxWinLen = Math.max(maxWinLen, r - l + 1);
        }

        return maxWinLen;
    }
}
