package com.mark.strategy.pay;

/**
 * @author Mark
 * @date 2020/5/14 11:55
 */
public class AliPay extends Payment {
    @Override
    public String getName() {
        return "支付宝";
    }

    @Override
    protected double queryBalance(String uid) {
        return 900;
    }
}
