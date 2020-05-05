package com.mark.proxy.eg;

/**
 * @author Mark
 * @date 2020/5/4 11:55
 */
public class OrderDao {
    public int insert(Order order) {
        System.out.println("OrderDao 创建 Order 成功 = " + order);
        return 1;
    }
}
