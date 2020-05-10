package com.mark.adapter.obj;

/**
 * @author Mark
 * @date 2020/5/10 14:59
 */
public class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public int request() {
        return adaptee.specialRequest();
    }
}
