package com.mark.visitor.uml;

/**
 * @author Mark
 * @date 2020/5/27 14:53
 */
public interface IVisitor {

    void visit(ConcreteElementA elementA);

    void visit(ConcreteElementB elementB);
}
