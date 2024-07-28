package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix1091 {
    private class Triple {

        int row, col, dis;

        Triple(int dis, int row, int col) {
            this.dis = dis;
            this.row = row;
            this.col = col;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) return -1;
        Queue<Triple> q = new LinkedList<>();
        int n = grid.length;
        int[][] dis = new int[n][n];
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) dis[i][j] = Integer.MAX_VALUE;
        dis[0][0] = 1;
        q.add(new Triple(1, 0, 0));

        int[] drow = {1, 0, -1, 0, 1, 1, -1, -1};
        int[] dcol = {0, 1, 0, -1, 1, -1, -1, 1};

        while (!q.isEmpty()) {
            Triple front = q.poll();
            int row = front.row;
            int col = front.col;
            int d = front.dis;

            for (int i = 0; i < 8; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < n && grid[nrow][ncol] == 0 && d + 1 < dis[nrow][ncol]) {
                    dis[nrow][ncol] = d + 1;
                    q.add(new Triple(d + 1, nrow, ncol));
                }
            }
        }

        return (dis[n - 1][n - 1] == Integer.MAX_VALUE) ? -1 : dis[n - 1][n - 1];
    }
}
