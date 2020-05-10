package com.mark.adapter.interfaces;

/**
 * @author Mark
 * @date 2020/5/10 15:17
 */
public class Adapter implements Target {

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public int request1() {
        return 0;
    }

    @Override
    public int request2() {
        return 0;
    }

    @Override
    public int request3() {
        return 0;
    }

    @Override
    public int request4() {
        return 0;
    }
}
