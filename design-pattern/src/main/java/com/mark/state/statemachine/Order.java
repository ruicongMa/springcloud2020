package com.mark.state.statemachine;

/**
 * @author Mark
 * @date 2020/5/22 11:39
 */
public class Order {

    private int id;
    private OrderStatus orderStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "订单号：" + id +
                "，订单状态：" + orderStatus;
    }
}
