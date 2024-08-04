package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class NearestExitFromEntranceInMaze1926 {

    private class Triple {
        int steps, row, col;

        Triple(int steps, int row, int col) {
            this.steps = steps;
            this.row = row;
            this.col = col;
        }
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<Triple> q = new LinkedList<>();
        int[] drow = {1, 0, -1, 0};
        int[] dcol = {0, 1, 0, -1};

        int n = maze.length;
        int m = maze[0].length;
        int[][] vis = new int[n][m];

        q.add(new Triple(0, entrance[0], entrance[1]));
        vis[entrance[0]][entrance[1]] = 1;

        while (!q.isEmpty()) {
            int steps = q.peek().steps;
            int row = q.peek().row;
            int col = q.peek().col;
            q.poll();


            if (!(row == entrance[0] && col == entrance[1]) && (row == 0 || row == n - 1 || col == 0 || col == m - 1))
                return steps;

            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && maze[nrow][ncol] == '.' && vis[nrow][ncol] == 0) {
                    vis[nrow][ncol] = 1;
                    q.add(new Triple(steps + 1, nrow, ncol));
                }
            }
        }
        return -1;
    }
}
