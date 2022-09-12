package com.moe.passbook;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mark
 * @date 2022/5/25 20:47
 */
public class MyTest {

    @Test
    public void test01() {
        System.out.println(new StringBuilder("abc").reverse().toString());
        Map<String, String> map = new HashMap<>();
        System.out.println(map.get("abc"));
        System.out.println(map.getOrDefault("abc", "moe"));
        Map<String, Student> studentMap = new HashMap<>();
        System.out.println(map.get("aaa"));
        Student student = new Student();
    }

    public static class Student {

    }
}
