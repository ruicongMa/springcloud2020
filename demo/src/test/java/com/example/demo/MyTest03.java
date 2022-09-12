package com.example.demo;

import java.util.Scanner;

/**
 * @author Mark
 * @date 2022/6/18 23:57
 */
public class MyTest03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入会员积分：");
            if (scanner.hasNextInt()) {
                int score = scanner.nextInt();
                if (score >= 8000) {
                    System.out.println("该会员享受的折扣是：0.6");
                } else if (score >= 4000) {
                    System.out.println("该会员享受的折扣是：0.7");
                } else if (score >= 2000) {
                    System.out.println("该会员享受的折扣是：0.8");
                } else {
                    System.out.println("该会员享受的折扣是：0.9");
                }
                break;
            } else {
                System.out.println("你录入的积分不是整数！请输入整数：");
                scanner.next();
            }
        }
    }

    // public static void main(String[] args) {
    //     Scanner scanner = new Scanner(System.in);
    //     while (true) {
    //         System.out.println("请输入会员积分：");
    //         if (!scanner.hasNextInt()) {
    //             System.out.println("你录入的积分不是整数！请输入整数：");
    //             scanner.next();
    //             continue;
    //         }
    //         int score = scanner.nextInt();
    //         if (score >= 8000) {
    //             System.out.println("该会员享受的折扣是：0.6");
    //         } else if (score >= 4000) {
    //             System.out.println("该会员享受的折扣是：0.7");
    //         } else if (score >= 2000) {
    //             System.out.println("该会员享受的折扣是：0.8");
    //         } else {
    //             System.out.println("该会员享受的折扣是：0.9");
    //         }
    //         break;
    //     }
    // }
}
