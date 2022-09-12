package com.markzoe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mark
 * @date 2021/8/19 19:00
 */
@RestController
public class HelloController {

    @GetMapping("hi")
    public String hi(String name, int age) {
        return name + "==>" + age;
    }
}
