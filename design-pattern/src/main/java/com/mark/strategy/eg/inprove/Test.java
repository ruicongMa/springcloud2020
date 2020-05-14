package com.mark.strategy.eg.inprove;

import com.mark.strategy.eg.IPromotionStrategy;

/**
 * @author Mark
 * @date 2020/5/14 11:38
 */
public class Test {

    public static void main(String[] args) {
        String promotionKey = "COUPON";

        IPromotionStrategy strategy = PromotionStrategyFactory.getPromotionStrategy(promotionKey);
        strategy.promotion();
    }
}
