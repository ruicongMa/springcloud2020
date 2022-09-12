package com.moe.juc.c_023_01_Containers;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Mark
 * @date 2022/5/16 20:35
 */
public class HelloQueue {

    public static void main(String[] args) {
        Queue<Integer> q = new ArrayBlockingQueue<>(2);
        q.add(0);
        q.add(1);
        q.offer(2);
        q.offer(3);
        System.out.println(q);
    }
}
