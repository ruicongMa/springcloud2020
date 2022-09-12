package com.moe.juc.c_025;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Mark
 * @date 2022/5/16 22:35
 */
public class T06_ArrayBlockingQueue {

    static BlockingQueue<String> strs = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            strs.put("a" + i);
        }
        //strs.put("aaa"); //满了就会等待，程序阻塞
        //strs.add("aaa"); // 满了就抛异常
        //strs.offer("aaa"); // 满了加不进去，返回false
        strs.offer("aaa", 1, TimeUnit.SECONDS); // 尝试指定时间的往进加
        System.out.println(strs);
    }
}
