package com.mark.proxy;

/**
 * @author Mark
 * @date 2020/5/4 10:35
 */
public class Proxy implements ISubject {

    private ISubject iSubject;

    public Proxy(ISubject iSubject) {
        this.iSubject = iSubject;
    }

    @Override
    public void request() {
        before();
        iSubject.request();
        after();
    }

    public void before() {
        System.out.println("called before request().");
    }

    public void after() {
        System.out.println("called after request().");
    }
}
