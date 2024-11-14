package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int top = 0, left = 0, right = matrix[0].length - 1, bottom = matrix.length - 1;
        while (left <= right && top <= bottom) {
            for (int j = left; j <= right; j++) {
                ans.add(matrix[top][j]);
            }
            top++;

            for (int j = top; j <= bottom; j++) {
                ans.add(matrix[j][right]);
            }
            right--;
            if (top <= bottom)
                for (int j = right; j >= left; j--) {
                    ans.add(matrix[bottom][j]);
                }
            bottom--;
            if (left <= right)
                for (int j = bottom; j >= top; j--) {
                    ans.add(matrix[j][left]);
                }
            left++;


        }
        return ans;
    }
}
