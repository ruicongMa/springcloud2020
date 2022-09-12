package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Mark
 * @date 2022/6/17 15:09
 */
@RestController
public class TestController {

    @PostMapping("/test1")
    public Object test1(@RequestParam("list") List<String> list) {
        return list;
    }

    @PostMapping("/test2")
    public Object test2(@RequestBody List<String> list) {
        return list;
    }
}
