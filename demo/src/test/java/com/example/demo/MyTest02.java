package com.example.demo;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * @author Mark
 * @date 2022/6/5 23:17
 */
public class MyTest02 {

    @Test
    public void demo01() {
        int a = 10;
        long b = 10L;
        double c = 10.0;
        System.out.println(a == b);
        System.out.println(b == c);
        System.out.println(a == c);
        int num = 9_9;
        System.out.println(num);
        float pi = 3.14_15F;
        System.out.println(pi);
    }

    @Test
    public void demo02() {
        Set<Integer> set = new HashSet<>();
        Random r = new Random();
        for (; set.size() < 10; ) {
            int num = r.nextInt(20) + 1;
            set.add(num);
            System.out.println(num);
        }
        System.out.println("=====================");
        for (Integer num : set) {
            System.out.println(num);
        }
    }

    @Test
    public void demo03() {
        Set<Integer> set = new HashSet<>();
        Random r = new Random();
        for (; set.size() < 10; ) {
            int num = r.nextInt(20) + 1;
            set.add(num);
            System.out.println(num);
        }
        System.out.println("=====================");
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void demo04() {
        Set<Integer> set = new HashSet<>();
        Random r = new Random();
        for (; set.size() < 10; ) {
            int num = r.nextInt(20) + 1;
            set.add(num);
            System.out.println(num);
        }
        System.out.println("=====================");
        set.forEach(System.out::println);
    }

    @Test
    public void demo05() {
        Set<Integer> set = new HashSet<>();
        Random r = new Random();
        for (; set.size() < 10; ) {
            int num = r.nextInt(20) + 1;
            set.add(num);
            System.out.println(num);
        }
        System.out.println("=====================");
        Integer[] array = set.toArray(new Integer[]{});
        for (Integer num : array) {
            System.out.println(num);
        }
        System.out.println("=====================");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
