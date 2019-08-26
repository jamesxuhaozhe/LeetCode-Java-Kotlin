package dynamic_programming.best_time_to_buy_and_sell_stock_121;

/**
 * Problem link: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 *
 * Time complexity: O(n)
 *
 * Space complexity: O(1)
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                int profit = prices[i] - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }
}
