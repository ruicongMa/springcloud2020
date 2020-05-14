package com.mark.strategy.eg;

/**
 * @author Mark
 * @date 2020/5/14 11:10
 */
public class CashBackStrategy implements IPromotionStrategy {
    @Override
    public void promotion() {
        System.out.println("返现，直接打款到支付宝账号");
    }
}
