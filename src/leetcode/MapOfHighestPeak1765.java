package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MapOfHighestPeak1765 {
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length, m = isWater[0].length;
        int[][] res = new int[n][m];
        for (int[] row : res) Arrays.fill(row, -1);
        Queue<int[]> q = new LinkedList<>();
        int[] drow = {1, 0, -1, 0};
        int[] dcol = {0, 1, 0, -1};


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isWater[i][j] == 1) {
                    res[i][j] = 0;
                    q.add(new int[]{i, j});
                }
            }
        }

        int currLevel = 1;

        while (!q.isEmpty()) {
            int levelSize = q.size();

            for (int i = 0; i < levelSize; i++) {
                int[] curr = q.poll();

                for (int d = 0; d < 4; d++) {
                    int nrow = curr[0] + drow[d];
                    int ncol = curr[1] + dcol[d];
                    if (isValid(nrow, ncol, n, m) && res[nrow][ncol] == -1) {
                        res[nrow][ncol] = currLevel;
                        q.add(new int[]{nrow, ncol});
                    }
                }
            }
            currLevel++;
        }

        return res;
    }

    private boolean isValid(int nrow, int ncol, int n, int m) {
        return nrow >= 0 && nrow < n && ncol >= 0 && ncol < m;
    }
}
