package com.mark.adapter.obj;

/**
 * @author Mark
 * @date 2020/5/10 15:00
 */
public class Test {
    public static void main(String[] args) {
        Adapter adapter = new Adapter(new Adaptee());
        adapter.request();
    }
}
