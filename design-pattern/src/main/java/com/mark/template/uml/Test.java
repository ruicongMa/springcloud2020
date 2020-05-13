package com.mark.template.uml;

/**
 * @author Mark
 * @date 2020/5/13 9:37
 */
public class Test {

    public static void main(String[] args) {
        ConcreteClassA concreteClassA = new ConcreteClassA();
        concreteClassA.templateMethod();

        ConcreteClassB concreteClassB = new ConcreteClassB();
        concreteClassB.templateMethod();
    }
}
