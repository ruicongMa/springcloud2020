package com.mark.strategy.uml;

/**
 * @author Mark
 * @date 2020/5/14 10:46
 */
public class Context {

    private IStrategy iStrategy;

    public Context(IStrategy iStrategy) {
        this.iStrategy = iStrategy;
    }

    public void algorithm() {
        iStrategy.algorithm();
    }
}
