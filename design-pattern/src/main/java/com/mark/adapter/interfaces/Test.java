package com.mark.adapter.interfaces;

/**
 * @author Mark
 * @date 2020/5/10 15:18
 */
public class Test {
    public static void main(String[] args) {
        Adapter adapter = new Adapter(new Adaptee());
        adapter.request1();
        adapter.request2();
        adapter.request3();
        adapter.request4();
    }
}
