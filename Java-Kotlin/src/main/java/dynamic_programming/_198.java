package dynamic_programming;

public class _198 {

    /**
     * f(k) = 从前 k 个房屋中能抢劫到的最大数额，A[i]表示第i个房间的钱
     * f(1) = A[1]
     * f(2) = Max(A[1], A[2])
     * f(3) = A[3] + f(1) or f(2) which ever is greater
     * f(n) = Max(A[n] + f(n - 2), f(n - 1))
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }

        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[n + 1];
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0], nums[1]);
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max((nums[i - 1] + dp[i - 2]), dp[i - 1]);
        }
        return dp[n];
    }

    /**
     * 状态压缩过后
     *
     * @param nums
     * @return
     */
    public int rob1(int[] nums) {
        int preMax = 0;
        int curMax = 0;
        for (int x : nums) {
            int temp = curMax;
            curMax = Math.max(x + preMax, curMax);
            preMax = temp;
        }
        return curMax;
    }
}
