package com.mark.strategy.eg.inprove;

import com.mark.strategy.eg.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Mark
 * @date 2020/5/14 11:30
 */
public class PromotionStrategyFactory {

    private PromotionStrategyFactory() {
    }

    private static final Map<String, IPromotionStrategy> PROMOTIONS = new HashMap<>();
    private static final IPromotionStrategy EMPTY = new EmptyStrategy();

    static {
        PROMOTIONS.put(PromotionKey.COUPON, new CouponStrategy());
        PROMOTIONS.put(PromotionKey.CASHBACK, new CashBackStrategy());
        PROMOTIONS.put(PromotionKey.GROUPBUY, new GroupBuyStrategy());
    }

    public static IPromotionStrategy getPromotionStrategy(String promotionKey) {
        IPromotionStrategy strategy = PROMOTIONS.get(promotionKey);
        return strategy == null ? EMPTY : strategy;
    }

    private interface PromotionKey {
        String COUPON = "COUPON";
        String CASHBACK = "CASHBACK";
        String GROUPBUY = "GROUPBUY";
    }

    public static Set<String> getPromotionKeys() {
        return PROMOTIONS.keySet();
    }
}
