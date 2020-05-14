package com.mark.strategy.pay;

/**
 * @author Mark
 * @date 2020/5/14 11:55
 */
public class UnionPay extends Payment {
    @Override
    public String getName() {
        return "银联支付";
    }

    @Override
    protected double queryBalance(String uid) {
        return 120;
    }
}
