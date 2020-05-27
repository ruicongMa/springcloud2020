package com.mark.visitor.uml;

/**
 * @author Mark
 * @date 2020/5/27 14:58
 */
public class ConcreteVisitorB implements IVisitor {
    @Override
    public void visit(ConcreteElementA elementA) {
        elementA.operationA();
    }

    @Override
    public void visit(ConcreteElementB elementB) {
        elementB.operationB();
    }
}
