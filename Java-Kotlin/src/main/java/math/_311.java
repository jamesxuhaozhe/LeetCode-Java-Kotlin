package math;

public class _311 {

    /**
     * Based on the matrix multiplication rule. it is still though, ideally
     * we should leverage the fact that the matrix is sparse
     * @param A
     * @param B
     * @return
     */
    public int[][] multiply(int[][] A, int[][] B) {
        int ma = A.length;
        int na = A[0].length;

        int mb = B.length;
        int nb = B[0].length;

        int[][] result = new int[ma][nb];
        for (int i = 0; i < ma; i++) {
            for (int j = 0; j < nb; j++) {
                int curValue = 0;
                for (int k = 0; k < mb; k++) {
                    curValue += A[i][k] * B[k][j];
                }
                result[i][j] = curValue;
            }
        }

        return result;
    }
}
