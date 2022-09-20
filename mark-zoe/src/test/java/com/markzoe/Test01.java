package com.markzoe;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Mark
 * @date 2022/9/12 下午6:51
 */
public class Test01 {

    @Test
    public void test01() {
        List<String> list = new ArrayList<>();
        list.add("4");
        list.add("5");
        list.add("2");
        list.add("1");
        list.add("6");
        list.add("9");
        list.add("8");
        list.add("7");
        list.add("3");

        // list.sort(String::compareTo);
        Collections.sort(list);

        System.out.println(list);
    }
}
