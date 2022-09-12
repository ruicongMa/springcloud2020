package com.moe.juc.c_025;

import java.util.PriorityQueue;

/**
 * @author Mark
 * @date 2022/5/16 22:53
 */
public class T07_01_PriorityQueue {

    public static void main(String[] args) {
        PriorityQueue<String> q = new PriorityQueue<>();
        q.add("c");
        q.add("e");
        q.add("a");
        q.add("d");
        q.add("z");
        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }
    }
}
