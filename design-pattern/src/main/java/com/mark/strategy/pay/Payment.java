package com.mark.strategy.pay;

/**
 * @author Mark
 * @date 2020/5/14 11:50
 */

/**
 * 支付渠道
 */
public abstract class Payment {

    public abstract String getName();

    //通用逻辑放到抽象类里面实现
    public MsgResult pay(String uid, double amount) {
        //余额是否足够
        if (queryBalance(uid) < amount) {
            return new MsgResult(500, "支付失败", "余额不足");
        }
        return new MsgResult(200, "支付成功", "支付金额" + amount);
    }

    protected abstract double queryBalance(String uid);
}
