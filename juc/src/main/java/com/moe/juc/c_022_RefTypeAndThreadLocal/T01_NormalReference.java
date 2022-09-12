package com.moe.juc.c_022_RefTypeAndThreadLocal;

import java.io.IOException;

/**
 * @author Mark
 * @date 2022/5/16 17:38
 */
public class T01_NormalReference {

    public static void main(String[] args) throws IOException {
        M m = new M();
        m = null;
        System.gc(); //DisableExplicitGC

        System.in.read();
    }
}
