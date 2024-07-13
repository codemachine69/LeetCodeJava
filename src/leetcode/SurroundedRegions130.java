package leetcode;

public class SurroundedRegions130 {
    int[] drow = {1, 0, -1, 0};
    int[] dcol = {0, 1, 0, -1};
    int n, m;

    void dfs(char[][] board, int row, int col, boolean[][] visited) {
        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int newRow = row + drow[i];
            int newCol = col + dcol[i];
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !visited[newRow][newCol] && board[newRow][newCol] == 'O')
                dfs(board, newRow, newCol, visited);
        }
    }

    public void solve(char[][] board) {
        n = board.length;
        m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    if (!visited[i][j] && board[i][j] == 'O') {
                        dfs(board, i, j, visited);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
