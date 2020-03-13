package array._73;

public class Solution {

    public void setZeroes(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        boolean[] rowsFlag = new boolean[rowLength];
        boolean[] colsFlag = new boolean[colLength];

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (matrix[i][j] == 0) {
                    rowsFlag[i] = true;
                    colsFlag[j] = true;
                }
            }
        }

        for (int i = 0; i < rowsFlag.length; i++) {
            if (rowsFlag[i]) {
                removesRowZeros(matrix, i);
            }
        }

        for (int i = 0; i < colsFlag.length; i++) {
            if (colsFlag[i]) {
                removesColsZeros(matrix, i);
            }
        }

    }

    private void removesColsZeros(int[][] matrix, int col) {
        for (int j = 0; j < matrix.length; j++) {
            matrix[j][col] = 0;
        }
    }

    private void removesRowZeros(int[][] matrix, int row) {
        for (int j = 0; j < matrix[row].length; j++) {
            matrix[row][j] = 0;
        }
    }
}
