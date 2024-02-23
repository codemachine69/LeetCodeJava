package leetcode;

public class CountingBits338 {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 0;
        if (n != 0) ans[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) ans[i] = ans[i / 2];
            else ans[i] = 1 + ans[i / 2];
        }
        return ans;
    }
}
