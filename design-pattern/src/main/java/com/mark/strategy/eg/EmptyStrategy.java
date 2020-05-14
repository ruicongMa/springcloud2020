package com.mark.strategy.eg;

/**
 * @author Mark
 * @date 2020/5/14 11:12
 */
public class EmptyStrategy implements IPromotionStrategy {
    @Override
    public void promotion() {
        System.out.println("无优惠");
    }
}
