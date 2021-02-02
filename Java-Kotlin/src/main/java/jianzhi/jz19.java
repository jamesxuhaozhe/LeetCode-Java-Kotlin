package jianzhi;

import java.util.ArrayList;

public class jz19 {

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }

        ArrayList<Integer> result = new ArrayList<>();
        int low = 0;
        int high = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (low <= high && left <= right) {
            // going to the right
            for (int i = left; i <= right; i++) {
                result.add(matrix[low][i]);
            }

            // goint from top to bottom
            for (int i = low + 1; i <= high; i++) {
                result.add(matrix[i][right]);
            }

            //向左 有可能出现特殊的情况只有一行，为了避免重复访问
            if (low < high) {
                for (int i = right - 1; i >= left; i--) {
                    result.add(matrix[high][i]);
                }
            }

            //向上 有可能出现特殊的情况只有一列，为了避免重复访问
            if (left < right) {
                for (int i = high - 1; i >= low + 1; i--) {
                    result.add(matrix[i][left]);
                }
            }
            low++;
            high--;
            left++;
            right--;

        }
        return result;
    }
}
