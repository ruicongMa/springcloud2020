package com.mark.strategy.pay;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Mark
 * @date 2020/5/14 12:06
 */
@Data
@AllArgsConstructor
public class Order {

    private String uid;
    private String orderId;
    private double amount;

    public MsgResult pay() {
        return pay(PayStrategy.DEFAULT_PAY);
    }

    public MsgResult pay(String payKey) {
        Payment payment = PayStrategy.get(payKey);
        System.out.println("欢迎使用" + payment.getName());
        System.out.println("本次交易金额为：" + amount + "，开始扣款");
        return payment.pay(uid, amount);
    }
}
