package nowcoder;

public class nc59 {

    public int minPathSum(int[][] matrix) {
        // write code here
        if (!isValid(matrix)) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + matrix[0][i];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    continue;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    private static boolean isValid(int[][] matrix) {
        if (matrix == null) {
            return false;
        }
        int m = matrix.length;
        if (m < 1) {
            return false;
        }

        int n = matrix[0].length;
        if (n < 1) {
            return false;
        }

        return true;
    }
}
