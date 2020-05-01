package com.mrc.test;

import java.util.TreeSet;

/**
 * @author Mark
 * @date 2020/4/3 11:07
 */
public class Test {

    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<>();
        set.add("a");
        set.add("c");
        set.add("b");
        System.out.println(set);

        System.out.println(set.lower("c"));
    }
}
