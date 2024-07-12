package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix542 {
    private class Qobj {
        int r, c, d;

        Qobj(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }

    }

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];
        int[][] dist = new int[n][m];
        Queue<Qobj> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    vis[i][j] = 1;
                    q.add(new Qobj(i, j, 0));
                }
            }
        }

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, -1, 0, 1};


        while (!q.isEmpty()) {
            Qobj qobj = q.poll();
            int r = qobj.r;
            int c = qobj.c;
            int d = qobj.d;
            dist[r][c] = d;

            for (int i = 0; i < 4; i++) {
                int newR = r + drow[i];
                int newC = c + dcol[i];
                if (newR >= 0 && newR < n && newC >= 0 && newC < m && vis[newR][newC] == 0) {
                    vis[newR][newC] = 1;
                    q.add(new Qobj(newR, newC, d + 1));
                }
            }
        }
        return dist;
    }
}
