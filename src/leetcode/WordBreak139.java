package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> st = new HashSet<>();
        for (String word : wordDict) st.add(word);
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return solve(s, 0, st, dp) == 1 ? true : false;
    }

    private int solve(String s, int pos, Set<String> st, int[] dp) {
        if (pos == s.length()) return 1;
        if (dp[pos] != -1) return dp[pos];

        for (int i = pos; i < s.length(); i++) {
            if (st.contains(s.substring(pos, i + 1)) && solve(s, i + 1, st, dp) == 1) {
                return dp[pos] = 1;
            }
        }

        return dp[pos] = 0;
    }
}
