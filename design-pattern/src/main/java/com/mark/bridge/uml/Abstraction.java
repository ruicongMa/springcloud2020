package com.mark.bridge.uml;

/**
 * @author Mark
 * @date 2020/5/11 15:03
 */
public abstract class Abstraction {

    private IImplementor iImplementor;

    public Abstraction(IImplementor iImplementor) {
        this.iImplementor = iImplementor;
    }

    public void operation() {
        iImplementor.operationImpl();
    }
}
