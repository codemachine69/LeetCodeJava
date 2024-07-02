package leetcode;

public class NumberOfIslands200 {
    int m, n;

    private void dfs(int i, int j, char[][] grid, boolean[][] vis) {
        vis[i][j] = true;
        if (grid[i][j] == '0') return;

        if (i + 1 < m && !vis[i + 1][j]) dfs(i + 1, j, grid, vis);
        if (i - 1 >= 0 && !vis[i - 1][j]) dfs(i - 1, j, grid, vis);
        if (j + 1 < n && !vis[i][j + 1]) dfs(i, j + 1, grid, vis);
        if (j - 1 >= 0 && !vis[i][j - 1]) dfs(i, j - 1, grid, vis);
    }

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int cnt = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    dfs(i, j, grid, vis);
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
