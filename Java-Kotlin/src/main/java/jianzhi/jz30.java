package jianzhi;

public class jz30 {

    /**
     * 状态定义：dp[i]表示以i结尾的连续子数组的最大和。所以最终要求dp[n-1]
     * 状态转移方程：dp[i] = max(array[i], dp[i-1]+array[i])
     * 解释：如果当前元素为整数，并且dp[i-1]为负数，那么当然结果就是只选当前元素
     * 技巧：这里为了统一代码的书写，定义dp[i]表示前i个元素的连续子数组的最大和，结尾元素为array[i-1]
     **/
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int[] dp = new int[array.length + 1];
        dp[0] = 0;
        int max = array[0];
        for (int i = 1; i <= array.length; i++) {
            dp[i] = Math.max(array[i - 1], dp[i - 1] + array[i - 1]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // 这种写法跟上面一种本质上时一样的，上面的写法，处理的情况跟更统一。
    public int FindGreatestSumOfSubArrayTheSame(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        if (array.length == 1) {
            return array[0];
        }

        int[] dp = new int[array.length];
        dp[0] = array[0];
        int max = dp[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(array[i], dp[i - 1] + array[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
