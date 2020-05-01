package com.mark.singleton;

import com.mark.singleton.lazy.LazySimpleSingleton;
import org.junit.Test;

/**
 * @author Mark
 * @date 2020/4/29 11:03
 */
public class LazySimpleSingletonTest {

    @Test
    public void test() {
        new Thread(new MyThread()).start();
        new Thread(new MyThread()).start();
        System.out.println("end");
    }

    class MyThread implements Runnable {

        @Override
        public void run() {
            LazySimpleSingleton singleton = LazySimpleSingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + ": " + singleton);
        }
    }
}


