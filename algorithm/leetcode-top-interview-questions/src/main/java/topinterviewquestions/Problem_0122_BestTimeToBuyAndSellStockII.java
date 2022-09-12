package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/22 21:18
 */
public class Problem_0122_BestTimeToBuyAndSellStockII {

    // 能买多次交易
    // 122.买卖股票的最佳时机 II：https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans += Math.max(prices[i] - prices[i - 1], 0);
        }
        return ans;
    }
}
