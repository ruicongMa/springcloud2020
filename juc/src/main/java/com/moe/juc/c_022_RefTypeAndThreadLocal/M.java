package com.moe.juc.c_022_RefTypeAndThreadLocal;

/**
 * @author Mark
 * @date 2022/5/16 17:37
 */
public class M {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
    }
}
