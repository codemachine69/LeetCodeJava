package leetcode;

import java.util.HashMap;

public class FirstCompletelyPaintedRowOrColumn2661 {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] rowCnt = new int[m];
        int[] colCnt = new int[n];

        HashMap<Integer, Pair> hm = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                hm.put(mat[i][j], new Pair(i, j));
            }
        }


        for (int i = 0; i < arr.length; i++) {
            Pair p = hm.get(arr[i]);
            int elementRow = p.first;
            int elementCol = p.second;

            rowCnt[elementRow]++;
            colCnt[elementCol]++;

            if (rowCnt[elementRow] == n || colCnt[elementCol] == m) return i;
        }

        return -1;
    }
}
