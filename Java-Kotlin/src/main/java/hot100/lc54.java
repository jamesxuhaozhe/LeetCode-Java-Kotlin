package hot100;

import java.util.ArrayList;
import java.util.List;

public class lc54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }

        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        List<Integer> result = new ArrayList<>();
        while (left <= right && top <= bottom) {
            // from left to right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }

            // from top to bottom
            for (int i = top + 1; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }

            if (top < bottom) {
                for (int i = right - 1; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
            }

            if (left < right) {
                for (int i = bottom - 1; i >= top + 1; i--) {
                    result.add(matrix[i][left]);
                }
            }

            left++;
            right--;
            top++;
            bottom--;
        }
        return result;
    }
}
