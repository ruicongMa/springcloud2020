package com.moe.juc.c_026_01_ThreadPool;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * 假设你能够提供一个服务
 * 这个服务查询各大电商网站同一类产品的价格并汇总展示
 *
 * @author Mark
 * @date 2022/5/17 11:34
 */
public class T06_01_CompletableFuture {

    public static void main(String[] args) {
        long start, end;

        /*start = System.currentTimeMillis();
        priceOfTM();
        priceOfTB();
        priceOfJD();
        end = System.currentTimeMillis();
        System.out.println("use serial method call! " + (end - start));*/

        start = System.currentTimeMillis();

        CompletableFuture<Double> futureTM = CompletableFuture.supplyAsync(() -> priceOfTM());
        CompletableFuture<Double> futureTB = CompletableFuture.supplyAsync(() -> priceOfTB());
        CompletableFuture<Double> futureJD = CompletableFuture.supplyAsync(() -> priceOfJD());

        CompletableFuture.allOf(futureTM, futureTB, futureJD).join();
        // CompletableFuture.allOf(futureTM, futureTB, futureJD).get();

        end = System.currentTimeMillis();
        System.out.println("use completable future! " + (end - start));

        // CompletableFuture.supplyAsync(() -> priceOfTM())
        //         .thenApply(String::valueOf)
        //         .thenApply(str -> "price " + str)
        //         .thenAccept(System.out::println);
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double priceOfTM() {
        delay("TM");
        return 1.00;
    }

    private static double priceOfTB() {
        delay("TB");
        return 2.00;
    }

    private static double priceOfJD() {
        delay("JD");
        return 3.00;
    }

    /*private static double priceOfAmazon() {
        delay("Amazon");
        throw new RuntimeException("product not exist!");
    }*/

    private static void delay(String category) {
        int time = new Random().nextInt(500);
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s After %s sleep!\n", category, time);
    }
}
