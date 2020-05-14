package com.mark.strategy.eg;

/**
 * @author Mark
 * @date 2020/5/14 11:11
 */
public class GroupBuyStrategy implements IPromotionStrategy {
    @Override
    public void promotion() {
        System.out.println("5人拼团，可以优惠");
    }
}
