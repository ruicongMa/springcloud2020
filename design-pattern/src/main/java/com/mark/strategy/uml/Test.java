package com.mark.strategy.uml;

/**
 * @author Mark
 * @date 2020/5/14 10:49
 */
public class Test {

    public static void main(String[] args) {
        Context context = new Context(new ConcreteStrategyA());
        context.algorithm();
    }
}
