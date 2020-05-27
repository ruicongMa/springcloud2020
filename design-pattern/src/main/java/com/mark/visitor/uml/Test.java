package com.mark.visitor.uml;

/**
 * @author Mark
 * @date 2020/5/27 15:03
 */
public class Test {

    public static void main(String[] args) {
        ConcreteVisitorA visitorA = new ConcreteVisitorA();
        ConcreteVisitorB visitorB = new ConcreteVisitorB();
        ObjectStructure objectStructure = new ObjectStructure();
    }
}
