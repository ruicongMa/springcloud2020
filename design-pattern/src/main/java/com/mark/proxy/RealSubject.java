package com.mark.proxy;

/**
 * @author Mark
 * @date 2020/5/4 10:35
 */
public class RealSubject implements ISubject {
    @Override
    public void request() {
        System.out.println("real service is called.");
    }
}
