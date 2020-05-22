package com.mark.command.uml;

/**
 * @author Mark
 * @date 2020/5/21 9:36
 */
public class Test {

    public static void main(String[] args) {
        ConcreteCommand concreteCommand = new ConcreteCommand();
        concreteCommand.execute();

        Invoker invoker = new Invoker();
        invoker.action();

    }
}
