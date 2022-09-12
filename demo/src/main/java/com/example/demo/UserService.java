package com.example.demo;

import org.springframework.stereotype.Component;

/**
 * @author Mark
 * @date 2021/9/4 13:42
 */
@Component
public class UserService extends BaseService<OrderService, StockService> {

    public void test() {
        System.out.println(o);
    }
}
