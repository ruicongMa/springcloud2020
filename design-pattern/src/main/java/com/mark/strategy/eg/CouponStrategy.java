package com.mark.strategy.eg;

/**
 * @author Mark
 * @date 2020/5/14 11:08
 */
public class CouponStrategy implements IPromotionStrategy {
    @Override
    public void promotion() {
        System.out.println("使用优惠券抵扣");
    }
}
