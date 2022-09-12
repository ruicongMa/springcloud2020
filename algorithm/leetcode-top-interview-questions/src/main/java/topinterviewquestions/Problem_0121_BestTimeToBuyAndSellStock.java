package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/22 20:58
 */
public class Problem_0121_BestTimeToBuyAndSellStock {

    // 买卖股票的最佳时机：https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // 0...i 最小值
        int min = prices[0];
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            ans = Math.max(ans, prices[i] - min);
        }
        return ans;
    }

}
