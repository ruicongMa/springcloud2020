package com.moe.juc.c_023_01_Containers;

import java.util.Arrays;

/**
 * @author Mark
 * @date 2022/5/16 20:39
 */
public class T01_HelloArray {

    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Arrays.stream(a).map(i -> i + 1).forEach(i -> System.out.print(i + " "));
    }
}
