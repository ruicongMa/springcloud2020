package com.moe.juc.c_024_FromVectorToQueue;

import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * 有N张火车票，每张票都有一个编号
 * 同时有10个窗口对外售票
 * 请写一个模拟程序
 * <p>
 * 分析下面的程序可能会产生哪些问题？
 * <p>
 * 使用Vector或者Collections.synchronizedXXX
 * 分析一下，这样能解决问题吗？
 *
 * @author Mark
 * @date 2022/5/16 20:57
 */
public class TicketSeller2 {

    static Vector<String> tickets = new Vector<>();

    static {
        for (int i = 0; i < 1000; i++) tickets.add("票 编号：" + i);
    }

    // 最终还是会发生超卖或报错
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (tickets.size() > 0) { // 同步
                    try {
                        TimeUnit.MILLISECONDS.sleep(10); // 中间没加同步
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("销售了--" + tickets.remove(0)); // 同步
                }
            }).start();
        }
    }
}
