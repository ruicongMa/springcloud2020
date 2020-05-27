package com.mark.visitor;


/**
 * @author Mark
 * @date 2020/5/27 16:10
 */
public class Test {

    public static void main(String[] args) {
        String str = "1";
        Integer integer = 1;
        Test test = new Test();
        test.test(integer);
        test.test(str);
    }

    public void test(String str) {
        System.out.println("String");
    }

    public void test(Integer integer) {
        System.out.println("Integer");
    }
}
