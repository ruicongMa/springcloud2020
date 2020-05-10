package com.mark.adapter.clazz;

/**
 * @author Mark
 * @date 2020/5/10 11:50
 */
public class Adapter extends Adaptee implements Target {

    @Override
    public int request() {
        return specialRequest();
    }
}
