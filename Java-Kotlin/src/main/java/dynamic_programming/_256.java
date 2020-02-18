package dynamic_programming;

public class _256 {

    /**
     * Naive way of dynamic programming is to have a state space called dp, which is
     * dp[costs.length()][2], which stands for
     * lets say dp[0][0], at 0 level, this minimum cost if we paint the current one with the first color
     * dp[0][1], at 0 level, this minimum cost if we paint the current one with the second color
     * dp[0][2], at 0 level , this minimum cost if we paint the current one with the third color
     * @param costs
     * @return
     */
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        int m = costs.length;
        int[][] dp = new int[m][3];

        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]) + costs[i][j];
            }
        }

        return Math.min(Math.min(dp[m - 1][0], dp[m - 1][1]), dp[m - 1][2]);
    }

    /**
     * Same dp algo as above, but use constant space
     * @param costs
     * @return
     */
    public int minCost1(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        int firstMin = costs[0][0];
        int secondMin = costs[0][1];
        int thirdMin = costs[0][2];

        for (int i = 1; i < costs.length; i++) {
            int tempFirst = firstMin;
            int tempSecond = secondMin;
            int tempThird = thirdMin;
            firstMin = Math.min(tempSecond, tempThird) + costs[i][0];
            secondMin = Math.min(tempFirst, tempThird) + costs[i][1];
            thirdMin = Math.min(tempFirst, tempSecond) + costs[i][2];
        }

        return Math.min(Math.min(firstMin, secondMin), thirdMin);
    }
}
