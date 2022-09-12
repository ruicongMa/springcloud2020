package topinterviewquestions;

/**
 * @author Mark
 * @date 2022/3/22 22:28
 */
public class Problem_0123_BestTimeToBuyAndSellStockIII {

    // 能买2次交易
    // 买卖股票的最佳时机 III：https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int ans = 0;
        // doneOnceMinusBuyMax：（第一次交易完 - 第二次买入）的最大利润
        int doneOnceMinusBuyMax = -prices[0];
        int doneOnceMax = 0;// 0 : [0] - [0]
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            ans = Math.max(ans, doneOnceMinusBuyMax + prices[i]);
            min = Math.min(min, prices[i]);
            doneOnceMax = Math.max(doneOnceMax, prices[i] - min);
            // 两种可能性：1、i位置第二次不买 2、i位置第二次买
            doneOnceMinusBuyMax = Math.max(doneOnceMinusBuyMax, doneOnceMax - prices[i]);
        }
        return ans;
    }
}
