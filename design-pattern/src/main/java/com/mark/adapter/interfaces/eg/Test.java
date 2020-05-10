package com.mark.adapter.interfaces.eg;

/**
 * @author Mark
 * @date 2020/5/10 15:31
 */
public class Test {
    public static void main(String[] args) {
        DC adapter = new PowerAdapter(new AC220V());
        adapter.output5V();
    }
}
