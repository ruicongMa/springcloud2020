package com.mark.bridge.uml;

/**
 * @author Mark
 * @date 2020/5/11 15:05
 */
public class ConcreteImplementorA implements IImplementor {

    @Override
    public void operationImpl() {
        System.out.println("I am ConcreteImplementor A");
    }
}
