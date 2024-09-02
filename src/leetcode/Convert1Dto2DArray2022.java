package leetcode;

public class Convert1Dto2DArray2022 {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int len = original.length;
        if (m * n != len) return new int[0][0];
        int[][] res = new int[m][n];
        for (int i = 0; i < len; i++) res[i / n][i % n] = original[i];
        return res;
    }
}
