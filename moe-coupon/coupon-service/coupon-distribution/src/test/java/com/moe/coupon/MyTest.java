package com.moe.coupon;

import com.alibaba.fastjson.JSON;
import com.moe.coupon.entity.Coupon;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mark
 * @date 2022/5/23 17:13
 */
public class MyTest {

    @Test
    public void test03() {
        List<String> list = new ArrayList<>(3);
        list.add("a");
        list.add("b");
        list.stream().forEach(str -> {
            if (str.equals("a")) {
                return;
            }
            System.out.println(str);
        });
        System.out.println(list);
    }

    @Test
    public void test02() {
        Integer a = 128;
        Integer b = 128;
        System.out.println(a.equals(b));
        System.out.println(a == b);
    }

    @Test
    public void test01() {
        List<String> list = new ArrayList<>();
        list.add(null);
        list.add(null);
        System.out.println(list);
        List<Coupon> coupons = list.stream().map(item -> JSON.parseObject(item, Coupon.class)).collect(Collectors.toList());
        System.out.println(coupons);
        System.out.println(JSON.toJSONString(coupons));
    }
}
