package leetcode;

public class RowWithMaxOnes2643 {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int maxCount = -1, index = -1, n = mat.length, m = mat[0].length;
        for(int i=0; i<n; i++) {
            int count = 0;
            for(int j=0; j<m; j++) {
                if(mat[i][j] == 1) count++;
            }
            if (count > maxCount) {
                maxCount = count;
                index = i;
            }
        }
        return new int[]{index, maxCount};
    }
}
