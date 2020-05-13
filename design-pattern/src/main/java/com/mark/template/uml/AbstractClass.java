package com.mark.template.uml;

/**
 * @author Mark
 * @date 2020/5/13 9:11
 */
public abstract class AbstractClass {

    abstract public void step1();

    abstract public void step2();

    abstract public void step3();

    public void templateMethod() {
        step1();
        step2();
        step3();
    }
}
