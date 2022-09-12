package com.mark.singleton;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mark
 * @date 2022/7/13 16:46
 */
public class MyTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);

        List<Integer> subList = list.subList(0, list.size());
        System.out.println(subList);

        list.add(5);
        System.out.println(subList);
        System.out.println(list);

    }
}
