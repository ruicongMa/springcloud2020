package com.mark.adapter.obj.eg;

/**
 * @author Mark
 * @date 2020/5/10 12:10
 */
public class Test {
    public static void main(String[] args) {
        DC5 adapter = new PowerAdapter(new AC220V());
        adapter.outputDC5V();
    }
}
