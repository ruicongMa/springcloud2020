package com.mark.inerpreter.eg;

/**
 * @author Mark
 * @date 2020/5/25 17:46
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("Result:" + new Calculator("10 + 30").calculate());
        System.out.println("Result:" + new Calculator("10 + 30 - 20").calculate());
        System.out.println("Result:" + new Calculator("100 * 2 + 400 * 1 + 66").calculate());
    }
}
