package leetcode;

import java.util.PriorityQueue;

public class SwimInRisingWater778 {
    private class Cell {
        int diff, row, col;

        Cell(int diff, int row, int col) {
            this.diff = diff;
            this.row = row;
            this.col = col;
        }
    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        PriorityQueue<Cell> pq = new PriorityQueue<>((x, y) -> x.diff - y.diff);
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) dist[i][j] = Integer.MAX_VALUE;
        int[] drow = {1, 0, -1, 0};
        int[] dcol = {0, 1, 0, -1};
        int maxHeight = 0;

        dist[0][0] = grid[0][0];
        pq.add(new Cell(grid[0][0], 0, 0));


        while (!pq.isEmpty()) {
            int diff = pq.peek().diff;
            int row = pq.peek().row;
            int col = pq.peek().col;
            pq.poll();
            maxHeight = Math.max(maxHeight, diff);

            if (row == n - 1 && col == m - 1) return maxHeight;

            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m) {
                    int newHeight = Math.max(diff, grid[nrow][ncol]);

                    if (newHeight < dist[nrow][ncol]) {
                        dist[nrow][ncol] = newHeight;
                        pq.add(new Cell(newHeight, nrow, ncol));
                    }
                }
            }
        }

        return dist[n - 1][m - 1];
    }
}
