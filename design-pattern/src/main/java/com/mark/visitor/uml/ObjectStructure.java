package com.mark.visitor.uml;

/**
 * @author Mark
 * @date 2020/5/27 14:59
 */
public class ObjectStructure {

    private IElement element;

    public void accept(IVisitor visitor) {
        visitor.visit(new ConcreteElementA());
        visitor.visit(new ConcreteElementB());
    }
}
