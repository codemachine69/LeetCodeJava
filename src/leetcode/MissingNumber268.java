package leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MissingNumber268 {
    public int missingNumber_binarysearch(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left)/2;
            if(mid < nums[mid]) right = mid;
            else left = mid + 1;
        }
        return nums[left] > left ? left : left + 1;
    }

    public int missingNumber_formula(int[] nums) {
        int n = nums.length;
        int sum = IntStream.of(nums).sum();
        return (n*(n+1))/2 - sum;
    }

    public int missingNumber_xor(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i] ^ i;
        }
        return ans^nums.length;
    }
}
