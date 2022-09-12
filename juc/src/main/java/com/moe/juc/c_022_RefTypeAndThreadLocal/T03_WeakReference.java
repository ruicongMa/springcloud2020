package com.moe.juc.c_022_RefTypeAndThreadLocal;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

/**
 * 弱引用遭到gc就会回收
 *
 * @author Mark
 * @date 2022/5/16 17:58
 */
public class T03_WeakReference {

//     public static void main(String[] args) {
//         WeakReference<M> m = new WeakReference<>(new M());
//
//         System.out.println(m.get());
//         System.gc();
//         System.out.println(m.get());
//
//         ThreadLocal<M> tl = new ThreadLocal<>();
//         tl.set(new M());
//         tl.remove();
//     }

    private static final List<Object> LIST = new LinkedList<>();
    private static final ReferenceQueue<M> QUEUE = new ReferenceQueue<>();

    public static void main(String[] args) {

        WeakReference<M> weakReference = new WeakReference<>(new M(), QUEUE);

        new Thread(() -> {
            while (true) {
                LIST.add(new byte[1024 * 1024]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
                System.out.println(weakReference.get());
            }
        }).start();

        new Thread(() -> {
            while (true) {
                Reference<? extends M> poll = QUEUE.poll();
                if (poll != null) {
                    System.out.println("--- 弱引用对象被jvm回收了 ---- " + poll);
                }
            }
        }).start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
