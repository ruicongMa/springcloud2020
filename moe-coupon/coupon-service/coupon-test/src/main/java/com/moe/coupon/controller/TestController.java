package com.moe.coupon.controller;

import com.moe.coupon.annotation.IgnoreResponseAdvice;
import com.moe.coupon.vo.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author Mark
 * @date 2022/5/24 11:22
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/test01")
    public Map<String, String> test01() {
        Map<String, String> result = new HashMap<>();
        result.put("name", "zhangsan");
        result.put("age", "18");
        return result;
    }

    @GetMapping("/test02")
    @IgnoreResponseAdvice
    public Map<String, String> test02() {
        Map<String, String> result = new HashMap<>();
        result.put("name", "zhangsan");
        result.put("age", "18");
        return result;
    }

    @GetMapping("/test03")
    public List<Student> test03() {
        List<Student> list = new ArrayList<>();
        Student s1 = new Student("moe", 18, "北京市", Arrays.asList("篮球", "足球"));
        Student s2 = new Student("zoe", 18, "临汾市", Arrays.asList("游泳", "羽毛球"));
        list.add(s1);
        list.add(s2);
        return list;
    }
}
