package leetcode;

import java.util.PriorityQueue;

public class PathWithMinEffort1631 {

    private class Cell {
        int diff, row, col;

        Cell(int diff, int row, int col) {
            this.diff = diff;
            this.row = row;
            this.col = col;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        PriorityQueue<Cell> pq = new PriorityQueue<>((x, y) -> x.diff - y.diff);
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 0;
        pq.add(new Cell(0, 0, 0));

        int[] drow = {1, 0, -1, 0};
        int[] dcol = {0, 1, 0, -1};

        while (!pq.isEmpty()) {
            Cell front = pq.poll();
            int diff = front.diff;
            int row = front.row;
            int col = front.col;
            if (row == m - 1 && col == n - 1) return diff;
            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if (nrow >= 0 && ncol >= 0 && nrow < m && ncol < n) {
                    int neweffort = Math.max(Math.abs(heights[row][col] - heights[nrow][ncol]), diff);
                    if (neweffort < dist[nrow][ncol]) {
                        dist[nrow][ncol] = neweffort;
                        pq.add(new Cell(neweffort, nrow, ncol));
                    }
                }
            }
        }
        return dist[n - 1][m - 1];
    }
}
