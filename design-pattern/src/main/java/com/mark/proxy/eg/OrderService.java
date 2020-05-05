package com.mark.proxy.eg;

/**
 * @author Mark
 * @date 2020/5/4 12:01
 */
public class OrderService implements IOrderService {

    private OrderDao orderDao;

    //伪代码
    public OrderService() {
        this.orderDao = new OrderDao();
    }

    @Override
    public int createOrder(Order order) {
        System.out.println("OrderService 调用 orderDao 创建订单");
        return orderDao.insert(order);
    }
}
