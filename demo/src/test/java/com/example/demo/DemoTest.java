package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Mark
 * @date 2022/6/6 17:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DemoTest {


    @Autowired
    OrderService orderService;

    @Test
    public void demo() {
        System.out.println(orderService);
    }
}
