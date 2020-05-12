package com.mark.delegate.uml;

/**
 * @author Mark
 * @date 2020/5/12 9:52
 */
public class ConcreteA implements Task {
    @Override
    public void doTask() {
        System.out.println("A doTask...");
    }
}
