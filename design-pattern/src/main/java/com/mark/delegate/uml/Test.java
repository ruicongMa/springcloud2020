package com.mark.delegate.uml;

/**
 * @author Mark
 * @date 2020/5/12 9:54
 */
public class Test {

    public static void main(String[] args) {
        Delegate delegate = new Delegate();
        delegate.doTask(new ConcreteA());
    }
}
