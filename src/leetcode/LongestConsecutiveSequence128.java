package leetcode;

import java.util.HashSet;

public class LongestConsecutiveSequence128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int num : nums) hs.add(num);
        int maxCount = 0;
        for (int num : nums) {
            if (!hs.contains(num - 1)) {
                int currNum = num;
                int count = 0;
                while (hs.contains(currNum)) {
                    currNum++;
                    count++;
                }
                maxCount = Math.max(maxCount, count);
            }
        }

        return maxCount;
    }
}
