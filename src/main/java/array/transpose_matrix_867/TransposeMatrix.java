package array.transpose_matrix_867;

public class TransposeMatrix {

    public int[][] transpose(int[][] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        int row = A.length;
        int col = A[0].length;
        int[][] solution = new int[col][row];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                solution[c][r] = A[r][c];
            }
        }
        return solution;
    }
}
