package leetcode;

import java.util.HashSet;

public class LargestPositiveIntegerWithNegative2441 {
    public int findMaxK(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for (int x : nums) {
            if (hs.contains(-x)) {
                max = Integer.max(max, Math.abs(x));
            } else {
                hs.add(x);
            }
        }

        return max == Integer.MIN_VALUE ? -1 : max;
    }
}
