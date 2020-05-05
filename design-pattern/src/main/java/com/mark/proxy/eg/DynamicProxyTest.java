package com.mark.proxy.eg;

/**
 * @author Mark
 * @date 2020/5/4 15:20
 */
public class DynamicProxyTest {
    public static void main(String[] args) {
        try {
            Order order = new Order();
            order.setCreateTime(System.currentTimeMillis());

            IOrderService orderService = (IOrderService) new OrderServiceDynamicProxy().getInstance(new OrderService());
            orderService.createOrder(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
