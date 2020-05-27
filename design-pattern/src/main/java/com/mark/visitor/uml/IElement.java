package com.mark.visitor.uml;

/**
 * @author Mark
 * @date 2020/5/27 14:52
 */
public interface IElement {

    void accept(IVisitor visitor);
}
