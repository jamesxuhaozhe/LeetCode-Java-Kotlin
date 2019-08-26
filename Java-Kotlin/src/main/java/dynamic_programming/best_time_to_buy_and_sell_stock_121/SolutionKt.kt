package dynamic_programming.best_time_to_buy_and_sell_stock_121

/**
 * Problem link: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 *
 * Time complexity: O(n)
 *
 * Space complexity: O(1)
 */
class SolutionKt {

    fun maxProfit(prices: IntArray): Int {
        var minPrice = Int.MAX_VALUE
        var maxProfit = 0
        prices.forEachIndexed { _, price ->
            if (price < minPrice) {
                minPrice = price
            } else {
                val profit = price - minPrice
                if (profit > maxProfit) {
                    maxProfit = profit
                }
            }
        }

        return maxProfit
    }
}