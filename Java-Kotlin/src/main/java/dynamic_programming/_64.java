package dynamic_programming;

public class _64 {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //m * n grid
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j != n - 1) {
                    // on the bottom edge
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                } else if (j == n - 1 && i != m - 1) {
                    // on the right side edge
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                } else if (j != n - 1 && i != m - 1) {
                    // general dp deduction equation
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                } else {
                    // essentially let the right bottom one equal to the original grid
                    dp[i][j] = grid[i][j];
                }
            }
        }
        return dp[0][0];
    }

    // same as the above, just use less space
    public int minPathSum1(int[][] grid) {
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if(i == grid.length - 1 && j != grid[0].length - 1)
                    grid[i][j] = grid[i][j] +  grid[i][j + 1];
                else if(j == grid[0].length - 1 && i != grid.length - 1)
                    grid[i][j] = grid[i][j] + grid[i + 1][j];
                else if(j != grid[0].length - 1 && i != grid.length - 1)
                    grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j],grid[i][j + 1]);
            }
        }
        return grid[0][0];
    }
}
