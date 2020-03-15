package dynamic_programming;

import java.util.HashSet;
import java.util.Set;

public class _764 {

    /**
     * https://leetcode-cn.com/problems/largest-plus-sign/solution/zui-da-jia-hao-biao-zhi-by-leetcode/
     * @param N
     * @param mines
     * @return
     */
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        Set<Integer> ones = new HashSet<>();
        for (int[] mine : mines) {
            ones.add(mine[0] * N + mine[1]);
        }
        int result = 0;
        int[][] dp = new int[N][N];
        int count = 0;
        for (int row = 0; row < N; row++) {
            count = 0;
            for (int col = 0; col < N; col++) {
                count = ones.contains(row * N + col) ? 0 : count + 1;
                dp[row][col] = count;
            }

            count = 0;
            for (int col = N - 1; col >= 0; col--) {
                count = ones.contains(row * N + col) ? 0 : count + 1;
                dp[row][col] = Math.min(dp[row][col], count);
            }
        }

        for (int col = 0; col < N; col++) {
            count = 0;
            for (int row = 0; row < N; row++) {
                count = ones.contains(row * N + col) ? 0 : count + 1;
                dp[row][col] = Math.min(dp[row][col], count);
            }

            count = 0;
            for (int row = N - 1; row >= 0; row--) {
                count = ones.contains(row * N + col) ? 0 : count + 1;
                dp[row][col] = Math.min(dp[row][col], count);
                result = Math.max(result, dp[row][col]);
            }
        }

        return result;
    }
}
