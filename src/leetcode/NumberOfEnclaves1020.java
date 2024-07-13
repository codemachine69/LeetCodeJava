package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves1020 {
    private class Pair {
        int r, c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        int[] drow = {1, 0, -1, 0};
        int[] dcol = {0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    if (grid[i][j] == 1) {
                        q.add(new Pair(i, j));
                        vis[i][j] = 1;
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            Pair obj = q.poll();
            int r = obj.r;
            int c = obj.c;

            for (int i = 0; i < 4; i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0) {
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
