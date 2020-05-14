package com.mark.strategy.uml;

/**
 * @author Mark
 * @date 2020/5/14 10:49
 */
public class ConcreteStrategyA implements IStrategy {
    @Override
    public void algorithm() {
        System.out.println("ConcreteStrategyA algorithm");
    }
}
