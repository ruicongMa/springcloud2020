package com.mark.state.statemachine;

/**
 * @author Mark
 * @date 2020/5/22 11:58
 */

/**
 * 订单状态改变事件
 */
public enum OrderStatusChangeEvent {
    //支付、发货、确认收货
    PAYED, DELIVERY, RECEIVED;
}
