package nowcoder;

public class nc134 {

    // by definition
    public int[][] solve(int[][] a, int[][] b) {
        // write code here
        if (a == null || a.length == 0 || b == null || b.length == 0) {
            return new int[][]{};
        }

        int m = a.length;
        int n = a[0].length;
        int p = b[0].length;

        int[][] res = new int[m][p];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                int cur = 0;
                for (int k = 0; k < n; k++) {
                    cur += a[i][k] * b[k][j];
                }
                res[i][j] = cur;
            }
        }

        return res;
    }
}
