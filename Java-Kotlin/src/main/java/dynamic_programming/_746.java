package dynamic_programming;

public class _746 {

    /**
     * 1、每一个位置都有 2 个阶梯，1 个阶梯上一层楼，另 1 个阶梯上两层楼；
     * <p>
     * 2、上两个阶梯的体力值耗费是一样的，但是在不同位置消耗的体力值是不一样的；
     * <p>
     * 3、楼层顶部在数组之外。如果数组长度为 len，那么楼顶就在索引为 len 这个位置。
     * <p>
     * 状态：dp[i] 表示到索引为 i 位置再选择向上爬一共需要的体力开销。
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }

        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = Math.min(cost[1], cost[0] + cost[1]);
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }

        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

    /**
     * 状态压缩
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs1(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }

        int c1 = 0;
        int c2 = 0;

        for (int i = 0; i < cost.length; i++) {
            int curr = cost[i] + Math.min(c1, c2);
            c1 = c2;
            c2 = curr;
        }
        return Math.min(c1, c2);
    }
}
