package com.mark.state.statemachine;

/**
 * @author Mark
 * @date 2020/5/22 11:39
 */

/**
 * 订单状态
 */
public enum OrderStatus {
    //待支付，待发货，待收货，订单结束
    WAIT_PAYMENT, WAIT_DELIVER, WAIT_RECEIVE, FINISH;
}
