package com.mark.strategy.pay;

/**
 * @author Mark
 * @date 2020/5/14 11:55
 */
public class JDPay extends Payment {
    @Override
    public String getName() {
        return "京东白条";
    }

    @Override
    protected double queryBalance(String uid) {
        return 500;
    }
}
