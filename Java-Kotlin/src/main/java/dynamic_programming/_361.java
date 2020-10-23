package dynamic_programming;

public class _361 {

    public static void main(String[] args) {
        char[][] chars = new char[][]{{'0', 'E', '0', '0'}, {'E', '0', 'W', 'E'}, {'0', 'E', '0', '0'}};
        System.out.println(new _361().maxKilledEnemies(chars));
    }

    /**
     * This problem is similar to problem 764
     * https://leetcode-cn.com/problems/bomb-enemy/solution/hong-zha-di-ren-by-leetcode-solution/
     *
     * @return
     */
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int result = 0;
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int[][] dp = new int[rowLen][colLen];

        for (int row = 0; row < rowLen; row++) {
            int pre = 0;
            for (int col = 0; col < colLen; col++) {
                if (grid[row][col] == 'W') {
                    pre = 0;
                } else if (grid[row][col] == 'E') {
                    pre++;
                }
                dp[row][col] += pre;
            }

            pre = 0;
            for (int col = colLen - 1; col >= 0; col--) {
                if (grid[row][col] == 'W') {
                    pre = 0;
                } else if (grid[row][col] == 'E') {
                    pre++;
                }
                dp[row][col] += pre;
            }
        }

        for (int col = 0; col < colLen; col++) {
            int pre = 0;
            for (int row = 0; row < rowLen; row++) {
                if (grid[row][col] == 'W') {
                    pre = 0;
                } else if (grid[row][col] == 'E') {
                    pre++;
                }
                dp[row][col] += pre;
            }

            pre = 0;
            for (int row = rowLen - 1; row >= 0; row--) {
                if (grid[row][col] == 'W') {
                    pre = 0;
                } else if (grid[row][col] == 'E') {
                    pre++;
                }
                dp[row][col] += pre;
            }
        }

        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (grid[row][col] == '0') {
                    result = Math.max(result, dp[row][col]);
                }
            }
        }

        return result;
    }
}
