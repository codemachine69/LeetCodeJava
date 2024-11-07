package leetcode;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingChars3 {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        HashSet<Character> hs = new HashSet<>();
        int left = 0, right = 0;
        int maxlength = 0;

        while (right < arr.length) {
            if (!hs.contains(arr[right])) {
                hs.add(arr[right]);
                maxlength = Integer.max(maxlength, right - left + 1);
                right++;
            } else {
                while (hs.contains(arr[right])) {
                    hs.remove(arr[left]);
                    left++;
                }
            }
        }
        return maxlength;

    }
}
