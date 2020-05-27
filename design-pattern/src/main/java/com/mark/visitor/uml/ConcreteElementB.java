package com.mark.visitor.uml;

/**
 * @author Mark
 * @date 2020/5/27 14:55
 */
public class ConcreteElementB implements IElement {
    @Override
    public void accept(IVisitor visitor) {

    }

    public int operationB() {
        return 0;
    }
}
