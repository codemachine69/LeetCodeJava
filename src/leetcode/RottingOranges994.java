package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges994 {
    private class Qobj {
        int r, c, t;

        Qobj(int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }

    public int orangesRotting(int[][] grid) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        Queue<Qobj> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Qobj(i, j, 0));
                }
                if (grid[i][j] == 1) {
                    cnt++;
                }
            }
        }

        int time = 0;
        int s = 0;

        while (!q.isEmpty()) {
            Qobj obj = q.poll();
            time = Math.max(time, obj.t);

            for (int i = 0; i < 4; i++) {
                int r = obj.r + dx[i];
                int c = obj.c + dy[i];
                if (r >= 0 && r < n && c >= 0 && c < m && grid[r][c] == 1) {
                    q.add(new Qobj(r, c, obj.t + 1));
                    grid[r][c] = 2;
                    s++;
                }
            }
        }

        if (cnt == s) return time;
        return -1;
    }
}
