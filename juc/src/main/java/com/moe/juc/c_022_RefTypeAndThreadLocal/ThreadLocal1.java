package com.moe.juc.c_022_RefTypeAndThreadLocal;

import java.util.concurrent.TimeUnit;

/**
 * ThreadLocal线程局部变量
 *
 * @author Mark
 * @date 2022/5/16 16:25
 */
public class ThreadLocal1 {

    volatile static Person p = new Person();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(p.name);
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p.name = "lisi";
        }).start();
    }
}

class Person {
    String name = "zhangsan";
}
