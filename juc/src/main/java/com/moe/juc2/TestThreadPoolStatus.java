package com.moe.juc2;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Mark
 * @date 2022/5/18 12:57
 */
public class TestThreadPoolStatus {

    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY = (1 << COUNT_BITS) - 1;

    // runState is stored in the high-order bits
    private static final int RUNNING = -1 << COUNT_BITS;
    private static final int SHUTDOWN = 0 << COUNT_BITS;
    private static final int STOP = 1 << COUNT_BITS;
    private static final int TIDYING = 2 << COUNT_BITS;
    private static final int TERMINATED = 3 << COUNT_BITS;

    private static final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));

    public static void main(String[] args) {

        System.out.println("CAPACITY => " + printNumBinary(CAPACITY));
        System.out.println("~CAPACITY => " + printNumBinary(~CAPACITY));
        System.out.println("======================================================");

        System.out.println("RUNNING => " + printNumBinary(RUNNING));
        System.out.println("SHUTDOWN => " + printNumBinary(SHUTDOWN));
        System.out.println("STOP => " + printNumBinary(STOP));
        System.out.println("TIDYING => " + printNumBinary(TIDYING));
        System.out.println("TERMINATED => " + printNumBinary(TERMINATED));
        System.out.println("======================================================");

        System.out.println("ctlOf => " + printNumBinary(ctlOf(RUNNING, 0)));
        System.out.println("runStateOf => " + printNumBinary(runStateOf(ctl.get())));
        System.out.println("workerCountOf => " + printNumBinary(workerCountOf(ctl.get())));
        System.out.println("======================================================");

        ctl.getAndIncrement();
        System.out.println("runStateOf => " + printNumBinary(runStateOf(ctl.get())));
        System.out.println("workerCountOf => " + printNumBinary(workerCountOf(ctl.get())));

    }

    // 打印一个数的二进制
    private static String printNumBinary(int num) {
        StringBuilder builder = new StringBuilder();
        for (int i = 31; i >= 0; i--) {
            builder.append(((num >> i) & 1) == 0 ? '0' : '1');
        }
        return builder.toString();
    }

    // Packing and unpacking ctl
    private static int runStateOf(int c) {
        return c & ~CAPACITY;
    }

    private static int workerCountOf(int c) {
        return c & CAPACITY;
    }

    private static int ctlOf(int rs, int wc) {
        return rs | wc;
    }
}
