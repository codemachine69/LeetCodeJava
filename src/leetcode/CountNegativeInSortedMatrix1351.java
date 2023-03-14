package leetcode;

public class CountNegativeInSortedMatrix1351 {
    public int countNegatives_bs(int[][] grid) {
        int count = 0;
        for (int i = 0, end = grid[i].length - 1; i < grid.length - 1; i++) {
            int start = 0;
            while (start <= end) {
                int mid = start + (end - start)/2;
                if(grid[i][mid] < 0) end = mid - 1;
                else start = mid + 1;
            }
            count += grid[i].length - start;
        }
        return count;
    }

    public int countNegatives_matTraverse(int[][] grid) {
        int m = grid.length, n = grid[0].length, count = 0;
        int i = m - 1, j = 0;
        while(i >= 0 && j < n) {
            if(grid[i][j] < 0) {
                count += n - j;
                i--;
            } else {
                j++;
            }
        }
        return count;
    }

    public int countNegatives_bruteforce(int[][] grid) {
        int count = 0;
        for (int[] row : grid) for (int x : row) if (x < 0) count++;
        return count;
    }
}
