package com.example.demo;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Mark
 * @date 2022/5/4 9:56
 */
public class MyTest01 {

    @Test
    public void test03() {
        System.out.println(aa());
    }

    public String aa() {
        try {
            return "aa";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        } finally {
            System.out.println("finally....");
        }
    }

    @Test
    public void test02() {
        System.out.println(560 % 500);
        System.out.println(560 - 560 % 500);
        System.out.println(1200 / 500);
        System.out.println(2 % 2);
        System.out.println(1200 - 1200 % 1200);
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        System.out.println(map.putIfAbsent("aaa", "hello"));
        System.out.println(map.get("aaa"));
        System.out.println(map.putIfAbsent("aaa", "hello"));
        map.putIfAbsent("aaa", "bbb");
        System.out.println(map.get("aaa"));
        System.out.println(map.putIfAbsent("aaa", "hello"));
        System.out.println(map.computeIfAbsent("bbb", t -> t + "moe"));
        System.out.println(map.computeIfAbsent("bbb", t -> t + "zzz"));
    }

    @Test
    public void test01() {
        String code = "220522";
        List<Character> chars = code.chars().mapToObj(item -> (char) item).collect(Collectors.toList());
        Collections.shuffle(chars);
        String result = chars.stream().map(Objects::toString).collect(Collectors.joining());
        System.out.println(result);
    }
}
