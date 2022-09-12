package com.example.demo;

// import org.junit.jupiter.api.Test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    OrderService orderService;

    // @Test
    @Test
    public void contextLoads() {
        System.out.println(orderService);
    }

    @Test
    public void test() {

    }


}
