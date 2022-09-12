package com.moe.juc.c_020_01_Interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 使用Latch（门闩）替代wait notify来进行通知
 * 好处是通信方式简单，同时也可以指定等待时间
 * 使用await和countdown方法替代wait和notify
 * CountDownLatch不涉及锁定，当count的值为零时当前线程继续运行
 * 当不涉及同步，只是涉及线程通信的时候，用synchronized + wait/notify就显得太重了
 * 这时应该考虑countdownlatch/cyclicbarrier/semaphore
 *
 * @author Mark
 * @date 2022/5/16 11:47
 */
public class T05_CountDownLatch {

    List lists = new ArrayList();

    public void add(Object o) {
        lists.add(o);
    }

    public int size() {
        return lists.size();
    }

    public static void main(String[] args) {
        T05_CountDownLatch c = new T05_CountDownLatch();

        CountDownLatch latch = new CountDownLatch(1);

        new Thread(() -> {
            System.out.println("t2 启动");
            if (c.size() != 5) {
                try {
                    latch.await();
                    //也可以指定等待时间
                    //latch.await(5000, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t2 结束");
        }, "t2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        new Thread(() -> {
            System.out.println("t1 启动");
            for (int i = 0; i < 10; i++) {
                c.add(new Object());
                System.out.println("add " + i);
                if (c.size() == 5) {
                    // 打开门闩，让t2得以执行
                    latch.countDown();
                }
                // try {
                // 	TimeUnit.SECONDS.sleep(1);
                // } catch (InterruptedException e) {
                // 	e.printStackTrace();
                // }
            }
            System.out.println("t1 结束");
        }, "t1").start();
    }
}
