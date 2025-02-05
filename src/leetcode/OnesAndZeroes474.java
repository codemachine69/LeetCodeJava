package leetcode;

import java.util.Arrays;

public class OnesAndZeroes474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        for (int i = 0; i <= strs.length; i++) for (int[] row : dp[i]) Arrays.fill(row, -1);
        return solve(0, m, n, strs, dp);
    }

    private int solve(int idx, int m, int n, String[] strs, int[][][] dp) {
        if (idx == strs.length) return 0;
        if (dp[idx][m][n] != -1) return dp[idx][m][n];

        String curr = strs[idx];
        int zero = 0, one = 0;
        for (char c : curr.toCharArray()) {
            if (c == '1') one++;
            else zero++;
        }
        dp[idx][m][n] = solve(idx + 1, m, n, strs, dp);
        if (m - zero >= 0 && n - one >= 0)
            dp[idx][m][n] = Math.max(dp[idx][m][n], 1 + solve(idx + 1, m - zero, n - one, strs, dp));
        return dp[idx][m][n];
    }
}
