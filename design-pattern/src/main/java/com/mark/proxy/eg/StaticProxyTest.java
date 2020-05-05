package com.mark.proxy.eg;

/**
 * @author Mark
 * @date 2020/5/4 14:40
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        try {
            Order order = new Order();
            order.setCreateTime(System.currentTimeMillis());
            IOrderService orderService = new OrderServiceStaticProxy(new OrderService());
            orderService.createOrder(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
