package com.mark.strategy.pay;

/**
 * @author Mark
 * @date 2020/5/14 12:09
 */
public class Test {

    public static void main(String[] args) {
        Order order = new Order("1", "111", 666);
        System.out.println(order.pay(PayStrategy.DEFAULT_PAY));
    }
}
