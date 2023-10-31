package leetcode;

import java.util.Arrays;

public class AssignCookies455 {
    public int findContentChildren(int[] g, int[] s) {
        int i = 0, j = 0;
        int len_g = g.length, len_s = s.length;
        Arrays.sort(g);
        Arrays.sort(s);

        while (i < len_g && j < len_s) {
            if (g[i] <= s[j]) {
                i++;
            }
            j++;
        }
        return i;
    }
}
