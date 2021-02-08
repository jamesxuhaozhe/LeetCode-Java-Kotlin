package jianzhi;

public class jz9 {

    /**
     * 设f[i] 表示 当前跳道第 i 个台阶的方法数。那么f[n]就是所求答案。
     * <p>
     * 假设现在已经跳到了第 n 个台阶，那么前一步可以从哪些台阶到达呢？
     * <p>
     * 如果上一步跳 1 步到达第 n 个台阶，说明上一步在第 n-1 个台阶。已知跳到第n-1个台阶的方法数为f[n-1]
     * <p>
     * 如果上一步跳 2 步到达第 n 个台阶，说明上一步在第 n-2 个台阶。已知跳到第n-2个台阶的方法数为f[n-2]
     * <p>
     * 。。。
     * <p>
     * 如果上一步跳 n 步到达第 n 个台阶，说明上一步在第 0 个台阶。已知跳到 第0个台阶的方法数为f[0]
     * <p>
     * 那么总的方法数就是所有可能的和。也就是f[n] = f[n-1] + f[n-2] + ... + f[0]
     * <p>
     * 显然初始条件f[0] = f[1] = 1
     * <p>
     * 所以我们就可以先求f[2]，然后f[3]...f[n-1]， 最后f[n]
     *
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {
        if (target <= 1) {
            return 1;
        }

        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= target; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j];
            }
        }
        return dp[target];
    }
}
