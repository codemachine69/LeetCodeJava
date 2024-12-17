package leetcode;

public class ConstructStringWithRepeatLimit2182 {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) freq[ch - 'a']++;

        StringBuilder res = new StringBuilder();
        int curr_idx = 25;

        while (curr_idx >= 0) {
            if (freq[curr_idx] == 0) {
                curr_idx--;
                continue;
            }

            int use = Math.min(freq[curr_idx], repeatLimit);
            for (int k = 0; k < use; k++) {
                res.append((char) ('a' + curr_idx));
            }
            freq[curr_idx] -= use;

            if (freq[curr_idx] > 0) {
                int small_idx = curr_idx - 1;
                while (small_idx >= 0 && freq[small_idx] == 0) {
                    small_idx--;
                }
                if (small_idx < 0) break;
                res.append((char) ('a' + small_idx));
                freq[small_idx]--;
            }
        }
        return res.toString();
    }
}
