package nowcoder;

public class nc4 {

    public int maxProfit(int[] prices) {
        // write code here
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                int curProfit = price - minPrice;
                if (curProfit > maxProfit) {
                    maxProfit = curProfit;
                }
            }
        }
        return maxProfit;
    }
}
