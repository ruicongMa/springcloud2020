package com.moe.juc.c_020_01_Interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * @author Mark
 * @date 2022/5/16 12:06
 */
public class T08_Semaphore {

    List lists = new ArrayList();

    public void add(Object o) {
        lists.add(o);
    }

    public int size() {
        return lists.size();
    }

    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {
        T08_Semaphore c = new T08_Semaphore();
        Semaphore s = new Semaphore(1);

        Thread t1 = new Thread(() -> {
            try {
                s.acquire();
                while (c.size() != 5) {
                    c.add(new Object());
                    System.out.println("add " + c.size());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                s.release();
            }

            try {
                t2.start();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                s.acquire();
                while (c.size() <= 10) {
                    c.add(new Object());
                    System.out.println("add " + c.size());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                s.release();
            }
        }, "t1");

        t2 = new Thread(() -> {
            try {
                s.acquire();
                System.out.println("t2 结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                s.release();
            }
        }, "t2");

        t1.start();
    }
}
