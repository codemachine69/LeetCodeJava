package leetcode;

public class MaxEnemyForts2511 {
    public int captureForts(int[] forts) {
        int max = 0;
        int l = 0;
        int len = forts.length;

        for (int r = 0; r < len; r++) {
            if (forts[r] != 0) {
                if (forts[l] == -forts[r]) {
                    max = Math.max(max, r - l - 1);
                }
                l = r;
            }
        }

        return max;
    }
}
