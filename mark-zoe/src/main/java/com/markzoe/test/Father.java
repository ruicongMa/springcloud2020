package com.markzoe.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.FutureTask;

/**
 * @author Mark
 * @date 2020/6/9 10:01
 */
public class Father {

    public Father() {
        System.out.println("father...");
    }

    public Map<String, String> test() {
        return null;
    }

    public static void main(String[] args) {
        int a = 10;
        long b = 10L;
        double c = 10.0;
        // System.out.println(a == b);
        // System.out.println(a == c);
        // System.out.println(b == c);
        //
        // Father father1 = new Father();
        // Father father2 = new Father();
        // System.out.println(father1.equals(father2));
        // Class<Integer> type = Integer.TYPE;

        new Son();

        FutureTask futureTask = new FutureTask(()->{
            System.out.println("ok");
            return null;
        });
        futureTask.run();

    }
}

class Son extends Father {

    @Override
    public HashMap<String, String> test() {
        return null;
    }
}