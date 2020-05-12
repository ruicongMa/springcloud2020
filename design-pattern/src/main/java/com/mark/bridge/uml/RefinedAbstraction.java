package com.mark.bridge.uml;

/**
 * @author Mark
 * @date 2020/5/11 15:06
 */
public class RefinedAbstraction extends Abstraction {

    public RefinedAbstraction(IImplementor iImplementor) {
        super(iImplementor);
    }

    @Override
    public void operation() {
        super.operation();
        System.out.println("refined operation");
    }
}
