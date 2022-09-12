package com.moe.juc.c_025;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author Mark
 * @date 2022/5/16 22:44
 */
public class T07_DelayQueue {

    static BlockingQueue<MyTask> tasks = new DelayQueue<>();

    static class MyTask implements Delayed {
        String name;
        long runningTime;

        MyTask(String name, long rt) {
            this.name = name;
            this.runningTime = rt;
        }

        @Override
        public int compareTo(Delayed o) {
            return (int) (this.getDelay(TimeUnit.MILLISECONDS)
                    - o.getDelay(TimeUnit.MILLISECONDS));
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(runningTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public String toString() {
            return name + " " + runningTime;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long now = System.currentTimeMillis();
        MyTask t1 = new MyTask("t1", now + 1000);
        MyTask t2 = new MyTask("t2", now + 2000);
        MyTask t3 = new MyTask("t3", now + 1500);
        MyTask t4 = new MyTask("t4", now + 2500);
        MyTask t5 = new MyTask("t5", now + 500);

        tasks.put(t1);
        tasks.put(t2);
        tasks.put(t3);
        tasks.put(t4);
        tasks.put(t5);

        System.out.println(tasks);

        while (!tasks.isEmpty()) {
            System.out.println(tasks.take());
        }
    }
}
