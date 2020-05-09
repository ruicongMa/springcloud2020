package com.mark.flyweight.eg;

/**
 * @author Mark
 * @date 2020/5/8 15:34
 */
public class IntegerTest {

    public static void main(String[] args) {
        Integer a = Integer.valueOf(100);
        Integer b = 100;

        Integer c = Integer.valueOf(1000);
        Integer d = 1000;

        System.out.println("a==b:" + (a == b));//true
        System.out.println("c==d:" + (c == d));//false
    }
}
