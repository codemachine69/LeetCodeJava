package leetcode;

public class FloodFill733 {
    int m, n;

    private void dfs(int row, int col, int[][] image, int color, boolean[][] vis, int oldColor) {
        vis[row][col] = true;
        image[row][col] = color;

//        if (row + 1 < m && !vis[row + 1][col] && image[row + 1][col] == oldColor)
//            dfs(row + 1, col, image, color, vis, oldColor);
//        if (col + 1 < n && !vis[row][col + 1] && image[row][col + 1] == oldColor)
//            dfs(row, col + 1, image, color, vis, oldColor);
//        if (row - 1 >= 0 && !vis[row - 1][col] && image[row - 1][col] == oldColor)
//            dfs(row - 1, col, image, color, vis, oldColor);
//        if (col - 1 >= 0 && !vis[row][col - 1] && image[row][col - 1] == oldColor)
//            dfs(row, col - 1, image, color, vis, oldColor);

        int[] dRow = {1, 0, -1, 0};
        int[] dCol = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !vis[newRow][newCol] && image[newRow][newCol] == oldColor) {
                dfs(newRow, newCol, image, color, vis, oldColor);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        m = image.length;
        n = image[0].length;
        boolean[][] vis = new boolean[m][n];
        int oldColor = image[sr][sc];
        dfs(sr, sc, image, color, vis, oldColor);

        return image;
    }
}
