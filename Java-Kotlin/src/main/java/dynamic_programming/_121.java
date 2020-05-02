package dynamic_programming;

/**
 * Problem link: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * <p>
 * Time complexity: O(n)
 * <p>
 * Space complexity: O(1)
 */
public class _121 {

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                int profit = price - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }
}
